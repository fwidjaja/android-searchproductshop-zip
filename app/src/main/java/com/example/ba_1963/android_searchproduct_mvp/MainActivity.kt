package com.example.ba_1963.android_searchproduct_mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.View
import com.example.ba_1963.android_searchproduct_mvp.model.ui.DataItemUiModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SearchContract.View {
    private val itemPresenter: SearchContract.Presenter = SearchPresenter(this, SearchRepository())
    private val itemAdapter = SearchAdapter()
    private var currPage: Int = 1
    private val recLayoutManager: GridLayoutManager = GridLayoutManager(
            this@MainActivity,
            2
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar.visibility = View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.let {
            menuInflater.inflate(R.menu.main_menu, menu)

            val searchMenu = menu.findItem(R.id.action_search)
            (searchMenu.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    itemList.apply {
                        layoutManager = recLayoutManager
                        adapter = itemAdapter
                    }
                    swipeRefreshLayout.setOnRefreshListener{
                        currPage = 1
                        itemPresenter.search(query, currPage)
                    }

                    var visibleItemCount: Int
                    var totalItemCount: Int
                    var pastVisibleItem: Int
                    itemList.addOnScrollListener(object: RecyclerView.OnScrollListener() {
                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                            super.onScrolled(recyclerView, dx, dy)

                            visibleItemCount = recLayoutManager.childCount
                            totalItemCount = recLayoutManager.itemCount
                            pastVisibleItem = recLayoutManager.findFirstVisibleItemPosition()
                            if ((visibleItemCount + pastVisibleItem) >= totalItemCount) {
                                itemPresenter.onEndListReached(q = query)
                            }
                        }
                    })

                    itemPresenter.search(query, currPage)
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }

            })
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun update(newData: MutableList<DataItemUiModel>) {
        itemAdapter.updateData(newData)
    }

    override fun showLoading(show: Boolean) {
        swipeRefreshLayout.isRefreshing = show
    }

    override fun loadNextPage(newItems: MutableList<DataItemUiModel>) {
        itemAdapter.loadNextPage(newItems = newItems)
    }

    override fun onDestroy() {
        super.onDestroy()
        itemPresenter.disposeComposite()
    }
}
