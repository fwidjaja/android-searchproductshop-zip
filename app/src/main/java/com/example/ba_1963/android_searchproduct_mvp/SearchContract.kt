package com.example.ba_1963.android_searchproduct_mvp

import com.example.ba_1963.android_searchproduct_mvp.model.ui.DataItemUiModel


interface SearchContract {
    interface View {
        fun update(newData: MutableList<DataItemUiModel>)
        fun showLoading(show: Boolean)
        fun loadNextPage(newItems: MutableList<DataItemUiModel>)
    }

    interface Presenter {
        fun update(q: String?)
        fun search(q: String?, start: Int)
        fun onEndListReached(q: String?)
    }
}