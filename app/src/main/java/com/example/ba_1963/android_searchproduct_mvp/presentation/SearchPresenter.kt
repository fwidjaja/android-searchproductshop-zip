package com.example.ba_1963.android_searchproduct_mvp.presentation

import com.example.ba_1963.android_searchproduct_mvp.domain.SearchUseCase
import com.example.ba_1963.android_searchproduct_mvp.presentation.product.ProductView
import com.example.ba_1963.android_searchproduct_mvp.presentation.shop.ShopView
import javax.inject.Inject

class SearchPresenter @Inject constructor(private val searchUseCase: SearchUseCase) {
    private var _productView: ProductView? = null
    private var _shopView: ShopView? = null
    private var _start: Int = 0
    private var _query: String? = null
    private val _device: String = "android"
    private val _ob: Int = 23
    private val _rows: Int = 12
    private val _source: String = "search"

    fun onLoadProduct(q: String?, start: Int) {
        _productView?.let { view ->
            _query = q
            _query?.let { _ ->
                _start = start
                _start.let { start ->
                    view.showLoading(true)
                    searchUseCase.getDataProducts(_device, _ob, q, _rows, _source, start).subscribe { dataUiModel ->
                        dataUiModel?.data?.products?.let {
                            view.loadProduct(it)
                            view.showLoading(false)
                        }
                    }
                }
            }
        }
    }

    fun onLoadProductNextPage() {
        _productView?.let { view ->
            view.showLoading(true)
            searchUseCase.getDataProducts(_device, _ob, _query, _rows, _source, _start+12).subscribe { dataUiModel ->
                dataUiModel?.data?.products?.let {
                    view.loadProductNextPage(it)
                    view.showLoading(false)
                }
            }
        }
        _start += 12
    }

    fun onLoadShop(q: String?, start: Int) {
        _shopView?.let { view ->
            _query = q
            _query?.let { _ ->
                _start = start
                _start.let { start ->
                    view.showLoading(true)
                    searchUseCase.getDataShops(_device, q, _rows, _source, start).subscribe { dataUiModel ->
                        dataUiModel?.result?.shops?.let {
                            view.loadShop(it)
                            view.showLoading(false)
                        }
                    }
                }
            }
        }
    }

    fun onLoadShopNextPage() {
        _shopView?.let { view ->
            view.showLoading(true)
            searchUseCase.getDataShops(_device, _query, _rows, _source, _start+12).subscribe { dataUiModel ->
                dataUiModel?.result?.shops?.let {
                    view.loadShopNextPage(it)
                    view.showLoading(false)
                }
            }
        }
        _start += 12
    }

    fun onProductViewCreated(view: ProductView) {
        this._productView = view
    }

    fun onShopViewCreated(view: ShopView) {
        this._shopView = view
    }

    fun onProductViewDestroyed() {
        _productView = null
    }

    fun onShopViewDestroyed() {
        _shopView = null
    }
}