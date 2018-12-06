package com.example.ba_1963.android_searchproduct_mvp

import com.example.ba_1963.android_searchproduct_mvp.api.API
import com.example.ba_1963.android_searchproduct_mvp.model.ui.DataItemUiModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SearchRepository : SearchDataSource {
    private var isLoading = false
    private val compositeDisposable = CompositeDisposable()

    override fun getData(
        q: String?, start: Int, onSuccess: (
            List<DataItemUiModel>?
        ) -> Unit
    ) {
        if (isLoading) return
        isLoading = true

        compositeDisposable.add(API.instance.getSearch(q, start)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ resultSearchDataModel ->
                    val datas = resultSearchDataModel?.datas?.let { datasRaw ->
                        datasRaw
                                .map { it.toUiModel() }
                                .filter { it != null }
                                .map { it!! }
                    }

                    onSuccess(datas)
                    isLoading = false

                }, {
                    isLoading = false
                }))
    }

    override fun dispose() {
        compositeDisposable.clear()
    }
}