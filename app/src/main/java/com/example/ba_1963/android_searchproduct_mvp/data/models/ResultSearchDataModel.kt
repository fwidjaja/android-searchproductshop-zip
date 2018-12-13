package com.example.ba_1963.android_searchproduct_mvp.data.models

import com.google.gson.annotations.SerializedName


data class ResultSearchDataModel (
        @SerializedName("status") val status: StatusDataModel?,
        @SerializedName("data") val datas: List<DataItemDataModel>?
)