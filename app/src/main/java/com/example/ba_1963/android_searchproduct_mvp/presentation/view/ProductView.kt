package com.example.ba_1963.android_searchproduct_mvp.presentation.view

import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.product.ProductsItemUiModel

interface ProductView: BaseView {
    fun loadProduct(newData: List<ProductsItemUiModel>)
    fun loadProductNextPage(newData: List<ProductsItemUiModel>)
}