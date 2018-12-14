package com.example.ba_1963.android_searchproduct_mvp.data.models.product

import com.google.gson.annotations.SerializedName


data class ResultProductDataModel (
        @SerializedName("data") val data: ProductDataItemDataModel?
)