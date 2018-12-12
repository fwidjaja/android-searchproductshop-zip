package com.example.ba_1963.android_searchproduct_mvp.data

import com.example.ba_1963.android_searchproduct_mvp.models.ui.DataItemUiModel


interface SearchDataSource {
    fun getData(
        q: String?, start: Int, onSuccess: (
            List<DataItemUiModel>?
        ) -> Unit
    )

    fun dispose()
}