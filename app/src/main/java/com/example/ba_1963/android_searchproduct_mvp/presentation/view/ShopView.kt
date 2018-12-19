package com.example.ba_1963.android_searchproduct_mvp.presentation.view

import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.shop.ItemShopUiModel

interface ShopView: BaseView {
    fun loadShop(newData: List<ItemShopUiModel>)
    fun loadShopNextPage(newData: List<ItemShopUiModel>)
}