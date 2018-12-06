package com.example.ba_1963.android_searchproduct_mvp

import com.example.ba_1963.android_searchproduct_mvp.model.ui.DataItemUiModel


interface SearchDataSource {
    fun getData(
        q: String?, start: Int, onSuccess: (
            List<DataItemUiModel>?
        ) -> Unit
    )

    fun dispose()
}