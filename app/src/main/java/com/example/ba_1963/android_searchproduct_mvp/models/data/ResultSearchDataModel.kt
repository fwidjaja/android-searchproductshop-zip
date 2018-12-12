package com.example.ba_1963.android_searchproduct_mvp.models.data

import com.example.ba_1963.android_searchproduct_mvp.models.ui.ResultSearchUiModel
import com.google.gson.annotations.SerializedName


data class ResultSearchDataModel (
        @SerializedName("status") val status: StatusDataModel?,
        @SerializedName("data") val datas: List<DataItemDataModel>?
) {
    fun toUiModel(): ResultSearchUiModel? {
        status?.let { status ->
            datas?.let { datas ->
                return ResultSearchUiModel(
                        status = status.toUiModel(),
                        datas = datas.map {
                            it.toUiModel()
                        }.filter { it != null }.map { it!! }
                )
            }
        } ?: return null
    }
}