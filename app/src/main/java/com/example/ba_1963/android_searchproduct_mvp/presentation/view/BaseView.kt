package com.example.ba_1963.android_searchproduct_mvp.presentation.view

import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.ProductsAndShopsUiModel

interface BaseView {
    fun showLoading(show: Boolean)
    fun loadProductsAndShops(newData: ProductsAndShopsUiModel)
}