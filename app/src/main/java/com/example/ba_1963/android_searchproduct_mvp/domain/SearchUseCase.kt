package com.example.ba_1963.android_searchproduct_mvp.domain

import com.example.ba_1963.android_searchproduct_mvp.data.SearchRepositoryInterface
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.ResultSearchUiModel
import com.example.ba_1963.android_searchproduct_mvp.domain.mapper.SearchMapper
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchUseCase @Inject constructor(private val searchRepository: SearchRepositoryInterface){
    fun getData(q: String?, start: Int): Observable<ResultSearchUiModel?>? {
        return searchRepository.getData(q, start)
                .map {
                    SearchMapper.resultToUiModel(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
    }
}