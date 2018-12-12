package com.example.ba_1963.android_searchproduct_mvp.search

import com.example.ba_1963.android_searchproduct_mvp.data.SearchDataSource
import com.example.ba_1963.android_searchproduct_mvp.models.ui.DataItemUiModel
import javax.inject.Inject

class SearchPresenter : SearchContract.Presenter {
    private var currentPage = 0
    var _view: SearchContract.View? = null
    var _dataSource: SearchDataSource? = null

    @Inject
    fun SearchPresenter(view: SearchContract.View, dataSource: SearchDataSource) {
        _view = view
        _dataSource = dataSource
    }

    override fun search(q: String?, start: Int) {
        currentPage = 0
        _view?.showLoading(true)
        _dataSource?.getData(
                q = q,
                start = start,
                onSuccess = { datas ->
                    val items = mutableListOf<DataItemUiModel>()

                    datas?.let { data ->
                        items.addAll(data)
                    }
                    _view?.update(items)
                    _view?.showLoading(false)
                })
    }

    override fun onEndListReached(q: String?) {
        _dataSource?.getData(
                q = q,
                start = currentPage + 10,
                onSuccess = { datas ->
                    val newItems = mutableListOf<DataItemUiModel>()

                    datas?.let { data ->
                        newItems.addAll(data)
                    }
                    _view?.loadNextPage(newItems = newItems)
                    currentPage += 10
                })
    }

    override fun disposeComposite() {
        _dataSource?.dispose()
    }
}