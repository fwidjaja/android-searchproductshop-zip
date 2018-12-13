package com.example.ba_1963.android_searchproduct_mvp.data

import com.example.ba_1963.android_searchproduct_mvp.api.SearchApi
import com.example.ba_1963.android_searchproduct_mvp.data.models.ResultSearchDataModel
import com.example.ba_1963.android_searchproduct_mvp.domain.mapper.SearchMapper
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.ResultSearchUiModel
import io.reactivex.Maybe
import javax.inject.Inject

@Suppress("UNCHECKED_CAST", "SENSELESS_COMPARISON")
class SearchRepository @Inject constructor(private val remoteDataSource: SearchApi): SearchRepositoryInterface {
    override fun getData(q: String?, start: Int): Maybe<ResultSearchDataModel> {
        return remoteDataSource.getSearch(q, start)
                .map { SearchMapper.resultToUiModel(it) }
                .filter { it != null } as Maybe<ResultSearchDataModel>
    }
}