package com.example.ba_1963.android_searchproduct_mvp.presentation.product

import com.example.ba_1963.android_searchproduct_mvp.presentation.models.product.ProductsItemUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.shop.ItemShopUiModel

interface ProductView {
    fun showLoading(show: Boolean)

    fun loadProduct(newData: List<ProductsItemUiModel>)
    fun loadProductNextPage(newData: List<ProductsItemUiModel>)
}