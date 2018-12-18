package com.example.ba_1963.android_searchproduct_mvp.presentation.shop

import com.example.ba_1963.android_searchproduct_mvp.presentation.models.product.ProductsItemUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.shop.ItemShopUiModel

interface ShopView {
    fun showLoading(show: Boolean)

    fun loadShop(newData: List<ItemShopUiModel>)
    fun loadShopNextPage(newData: List<ItemShopUiModel>)
}