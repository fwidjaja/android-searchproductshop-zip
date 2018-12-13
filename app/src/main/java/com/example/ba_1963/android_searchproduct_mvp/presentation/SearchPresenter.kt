package com.example.ba_1963.android_searchproduct_mvp.presentation

import com.example.ba_1963.android_searchproduct_mvp.domain.SearchUseCase
import javax.inject.Inject

class SearchPresenter @Inject constructor(private val searchUseCase: SearchUseCase) {
    var _view: SearchView? = null
    var _page: Int = 0
    var _query: String? = null

    fun onSearchButtonPressed(query: String?, start: Int) {
        _view?.let { view ->
            _query = query
            _query?.let { it ->
                _page = start
                _page?.let {
                    view.showLoading(true)
                    searchUseCase.getData(_query, start)
                            ?.subscribe { resultSearchUiModel ->
                                resultSearchUiModel?.datas?.let {
                                    view.update(it)
                                }
                            }
                }
            }
        }
    }

    fun onLoadNextPage() {
        _view?.let { view ->
            searchUseCase.getData(_query, _page+1)
                    ?.subscribe { resultSearchUiModel ->
                        resultSearchUiModel?.datas?.let {
                            _page += 1
                            view.loadNextPage(it)
                        }
                    }
        }
    }

    fun onViewCreated(view: SearchView) {
        this._view = view
    }

    fun onViewDestroyed() {
        _view = null
    }
}