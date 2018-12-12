package com.example.ba_1963.android_searchproduct_mvp.data

import com.example.ba_1963.android_searchproduct_mvp.api.ApiServiceInterface
import com.example.ba_1963.android_searchproduct_mvp.models.ui.DataItemUiModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

class SearchRepository : SearchDataSource {
    private var isLoading = false
    private val compositeDisposable = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()

    override fun getData(
        q: String?, start: Int, onSuccess: (
            List<DataItemUiModel>?
        ) -> Unit
    ) {
        if (isLoading) return
        isLoading = true

        compositeDisposable.add(api.getSearch(q, start)
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