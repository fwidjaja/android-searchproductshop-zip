package com.example.ba_1963.android_searchproduct_mvp

import com.example.ba_1963.android_searchproduct_mvp.model.ui.DataItemUiModel


class SearchPresenter(private val view: SearchContract.View, private val dataSource: SearchDataSource) : SearchContract.Presenter {
    private var currentPage = 1

    override fun update(q: String?) {
        currentPage = 1
        view.showLoading(true)
        dataSource.getData(
                q = q,
                start = currentPage,
                onSuccess = { datas ->
                    val items = mutableListOf<DataItemUiModel>()

                    datas?.let { data ->
                        items.addAll(data)
                    }
                    view.update(items)
                    view.showLoading(false)
                })
    }

    override fun search(q: String?, start: Int) {
        view.showLoading(true)
        dataSource.getData(
                q = q,
                start = start,
                onSuccess = { datas ->
                    val items = mutableListOf<DataItemUiModel>()

                    datas?.let { data ->
                        items.addAll(data)
                    }
                    view.update(items)
                    view.showLoading(false)
                })
    }

    override fun onEndListReached(q: String?) {
        dataSource.getData(
                q = q,
                start = currentPage + 1,
                onSuccess = { datas ->
                    val newItems = mutableListOf<DataItemUiModel>()

                    datas?.let { data ->
                        newItems.addAll(data)
                    }
                    view.loadNextPage(newItems = newItems)
                    currentPage++
                })
    }
}