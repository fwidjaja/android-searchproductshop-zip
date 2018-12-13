package com.example.ba_1963.android_searchproduct_mvp.data.models

import com.google.gson.annotations.SerializedName

data class StatusDataModel (@SerializedName("error_code") val errorCode: Int? = 0,
                       @SerializedName("message") val message: String? = ""
)