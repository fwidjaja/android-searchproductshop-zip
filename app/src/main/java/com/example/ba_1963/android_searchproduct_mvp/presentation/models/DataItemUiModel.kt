package com.example.ba_1963.android_searchproduct_mvp.presentation.models

import com.example.ba_1963.android_searchproduct_mvp.data.models.ShopDataModel

data class DataItemUiModel (
        var itemId: Long? = null,
        var itemName: String? = null,
        var itemUri: String? = null,
        var itemImg: String? = null,
        var itemPrice: String? = null,
        var itemShop: ShopDataModel? = null)