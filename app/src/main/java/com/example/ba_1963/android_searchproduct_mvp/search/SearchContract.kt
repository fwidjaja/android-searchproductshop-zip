package com.example.ba_1963.android_searchproduct_mvp.search

import com.example.ba_1963.android_searchproduct_mvp.models.ui.DataItemUiModel


interface SearchContract {
    interface View {
        fun update(newData: MutableList<DataItemUiModel>)
        fun showLoading(show: Boolean)
        fun loadNextPage(newItems: MutableList<DataItemUiModel>)
    }

    interface Presenter {
        fun search(q: String?, start: Int)
        fun onEndListReached(q: String?)
        fun disposeComposite()
    }
}