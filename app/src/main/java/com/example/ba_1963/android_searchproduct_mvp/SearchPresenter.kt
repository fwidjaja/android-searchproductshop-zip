package com.example.ba_1963.android_searchproduct_mvp

import com.example.ba_1963.android_searchproduct_mvp.model.ui.DataItemUiModel

class SearchPresenter(private val view: SearchContract.View, private val dataSource: SearchDataSource) : SearchContract.Presenter {
    private var currentPage = 0

    override fun search(q: String?, start: Int) {
        currentPage = 0
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
                start = currentPage + 10,
                onSuccess = { datas ->
                    val newItems = mutableListOf<DataItemUiModel>()

                    datas?.let { data ->
                        newItems.addAll(data)
                    }
                    view.loadNextPage(newItems = newItems)
                    currentPage += 10
                })
    }

    override fun disposeComposite() {
        dataSource.dispose()
    }
}