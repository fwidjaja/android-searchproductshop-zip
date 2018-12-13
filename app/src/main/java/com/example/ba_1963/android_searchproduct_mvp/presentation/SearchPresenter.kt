package com.example.ba_1963.android_searchproduct_mvp.presentation

import com.example.ba_1963.android_searchproduct_mvp.domain.SearchUseCase
import javax.inject.Inject

class SearchPresenter @Inject constructor(private val searchUseCase: SearchUseCase) {
    private var _view: SearchView? = null
    private var _start: Int = 0
    private var _query: String? = null

    fun onSearchButtonPressed(query: String?, start: Int) {
        _view?.let { view ->
            _query = query
            _query?.let { _ ->
                _start = start
                _start.let { start ->
                    view.showLoading(true)
                    searchUseCase.getData(_query, start)
                            ?.subscribe { resultSearchUiModel ->
                                resultSearchUiModel?.datas?.let {
                                    view.update(it)
                                    view.showLoading(false)
                                }
                            }
                }
            }
        }
    }

    fun onLoadNextPage() {
        _view?.let { view ->
            view.showLoading(true)
            searchUseCase.getData(_query, _start+10)
                    ?.subscribe { resultSearchUiModel ->
                        resultSearchUiModel?.datas?.let {
                            view.loadNextPage(it)
                            view.showLoading(false)
                        }
                    }
        }
        _start += 10
    }

    fun onViewCreated(view: SearchView) {
        this._view = view
    }

    fun onViewDestroyed() {
        _view = null
    }
}