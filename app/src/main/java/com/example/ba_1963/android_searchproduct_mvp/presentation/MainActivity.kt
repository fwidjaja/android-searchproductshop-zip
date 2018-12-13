package com.example.ba_1963.android_searchproduct_mvp.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import com.example.ba_1963.android_searchproduct_mvp.App
import com.example.ba_1963.android_searchproduct_mvp.R
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.DataItemUiModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), SearchView {

    @Inject
    lateinit var presenter: SearchPresenter
    private val itemAdapter = SearchAdapter()
    private var currPage: Int = 0
    private val recLayoutManager: GridLayoutManager = GridLayoutManager(
            this@MainActivity,
            2
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.appComponent.inject(this)

        presenter.onViewCreated(this)
    }

    override fun onDestroy() {
        presenter.onViewDestroyed()
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.let {
            menuInflater.inflate(R.menu.main_menu, menu)

            val searchMenu = menu.findItem(R.id.action_search)
            (searchMenu.actionView as android.support.v7.widget.SearchView).setOnQueryTextListener(object : android.support.v7.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    itemList.apply {
                        layoutManager = recLayoutManager
                        adapter = itemAdapter
                    }
                    swipeRefreshLayout.setOnRefreshListener{
                        currPage = 0
                        presenter.onSearchButtonPressed(query = query, start = currPage)
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
                                presenter.onLoadNextPage()
                            }
                        }
                    })

                    presenter.onSearchButtonPressed(query = query, start = currPage)
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
}