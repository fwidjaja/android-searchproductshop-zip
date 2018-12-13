package com.example.ba_1963.android_searchproduct_mvp.presentation.models

data class ItemShopUiModel (
    var id: Long? = null,
    var name: String? = null,
    var uri: String? = null,
    var isGold: Int? = null,
    var rating: Int? = null,
    var location: String? = null,
    var reputationImgUri: String? = null,
    var shopLucky: String? = null,
    var city: String? = null)