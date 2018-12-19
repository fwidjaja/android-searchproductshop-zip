package com.example.ba_1963.android_searchproduct_mvp.presentation.presenters

import com.example.ba_1963.android_searchproduct_mvp.domain.SearchUseCase
import com.example.ba_1963.android_searchproduct_mvp.presentation.view.ProductView
import com.example.ba_1963.android_searchproduct_mvp.presentation.view.ShopView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
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

    fun onLoadProductsAndShops(q: String?, start: Int) {
        _productView?.let { productView ->
            _query = q
            _query?.let { _ ->
                _start = start
                _start.let { start ->
                    productView.showLoading(true)
                    // shopView.showLoading(true)
                    searchUseCase.getProductsAndShops(_device, _ob, q, _rows, _source, start)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe { productsAndShopsUiModel ->
                        productsAndShopsUiModel.products.let {
                            productView.loadProduct(it)
                            productView.showLoading(false)
                        }
                        _shopView?.let {shopView ->
                            productsAndShopsUiModel.shops.let {
                                shopView.loadShop(it)
                                shopView.showLoading(false)
                            }
                        }
                    }
                }
            }
        }
    }

    fun onLoadProduct(q: String?, start: Int) {
        _productView?.let { view ->
            _query = q
            _query?.let { _ ->
                _start = start
                _start.let { start ->
                    view.showLoading(true)
                    searchUseCase.getDataProducts(_device, _ob, q, _rows, _source, start).subscribe { it ->
                        view.loadProduct(it)
                        view.showLoading(false)
                    }
                }
            }
        }
    }

    fun onLoadProductNextPage() {
        _productView?.let { view ->
            view.showLoading(true)
            searchUseCase.getDataProducts(_device, _ob, _query, _rows, _source, _start+12).subscribe { it ->
                view.loadProductNextPage(it)
                view.showLoading(false)
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
                    searchUseCase.getDataShops(_device, q, _rows, _source, start).subscribe { it ->
                        view.loadShop(it)
                        view.showLoading(false)
                    }
                }
            }
        }
    }

    fun onLoadShopNextPage() {
        _shopView?.let { view ->
            view.showLoading(true)
            searchUseCase.getDataShops(_device, _query, _rows, _source, _start+12).subscribe { it ->
                view.loadShopNextPage(it)
                view.showLoading(false)
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