package com.example.ba_1963.android_searchproduct_mvp.models.data

import com.example.ba_1963.android_searchproduct_mvp.models.ui.StatusUiModel
import com.google.gson.annotations.SerializedName

data class StatusDataModel (@SerializedName("error_code") val errorCode: Int? = 0,
                       @SerializedName("message") val message: String? = ""
) {
    fun toUiModel(): StatusUiModel? {
        errorCode?.let { errorCode ->
            message?.let { message ->
                return StatusUiModel(
                        errorCode = errorCode,
                        message = message
                )
            }
        } ?: return null
    }
}