package com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels

import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.product.ProductsItemUiModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.uimodels.shop.ItemShopUiModel

data class ProductsAndShopsUiModel (
        val products: List<ProductsItemUiModel>,
        val shops: List<ItemShopUiModel>)