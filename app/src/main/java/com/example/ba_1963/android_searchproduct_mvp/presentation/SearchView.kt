package com.example.ba_1963.android_searchproduct_mvp.presentation

import com.example.ba_1963.android_searchproduct_mvp.presentation.models.DataItemUiModel

interface SearchView {
    fun update(newData: List<DataItemUiModel>)
    fun showLoading(show: Boolean)
    fun loadNextPage(newItems: List<DataItemUiModel>)
}