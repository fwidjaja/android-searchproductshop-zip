package com.example.ba_1963.android_searchproduct_mvp.data

import com.example.ba_1963.android_searchproduct_mvp.data.models.ResultSearchDataModel
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.ResultSearchUiModel
import io.reactivex.Maybe


interface SearchRepositoryInterface {
    fun getData(q: String?, start: Int): Maybe<ResultSearchUiModel>
}