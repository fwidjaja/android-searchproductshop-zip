package com.example.ba_1963.android_searchproduct_mvp.presentation.view.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ba_1963.android_searchproduct_mvp.App

import com.example.ba_1963.android_searchproduct_mvp.R
import com.example.ba_1963.android_searchproduct_mvp.presentation.view.adapters.ProductAdapter
import com.example.ba_1963.android_searchproduct_mvp.presentation.presenters.SearchPresenter
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.ProductsAndShopsUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.view.ProductView
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.product.ProductsItemUiModel
import kotlinx.android.synthetic.main.fragment_product.*
import javax.inject.Inject

class ProductFragment : Fragment(), ProductView {
    private val itemAdapter = ProductAdapter()
    private var currPage: Int = 0
    private var isLoading = false
    private val recLayoutManager: GridLayoutManager = GridLayoutManager(
            activity,
            2
    )
    private var _query: String? = ""

    @Inject
    lateinit var presenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.appComponent.inject(this)
        presenter.onProductViewCreated(this)

        _query = activity?.intent?.getStringExtra("query")

        // presenter.onLoadProduct(_query, currPage)
        presenter.onLoadProductsAndShops(_query, currPage)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemList.apply {
            layoutManager = recLayoutManager
            adapter = itemAdapter
        }

        swipeRefreshLayout.setOnRefreshListener{
            currPage = 0
            // presenter.onLoadProduct(_query, currPage)
            presenter.onLoadProductsAndShops(_query, currPage)
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
                if ((visibleItemCount + pastVisibleItem) >= totalItemCount && !isLoading) {
                    presenter.onLoadProductNextPage()
                }
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun showLoading(show: Boolean) {
        isLoading = show
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.isRefreshing = show
        }
    }

    override fun loadProduct(newData: List<ProductsItemUiModel>) {
        itemAdapter.loadProduct(newData)
    }

    override fun loadProductNextPage(newData: List<ProductsItemUiModel>) {
        itemAdapter.loadProductNextPage(newItems = newData)
    }

    override fun loadProductsAndShops(newData: ProductsAndShopsUiModel) {
        itemAdapter.loadProduct(newData.products)
    }

    override fun onDestroy() {
        presenter.onProductViewDestroyed()
        super.onDestroy()
    }
}
