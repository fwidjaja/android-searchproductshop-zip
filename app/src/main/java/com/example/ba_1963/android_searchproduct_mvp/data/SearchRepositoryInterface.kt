package com.example.ba_1963.android_searchproduct_mvp.data

import com.example.ba_1963.android_searchproduct_mvp.data.models.ResultSearchDataModel
import io.reactivex.Maybe


interface SearchRepositoryInterface {
    fun getData(q: String?, start: Int): Maybe<ResultSearchDataModel>
}