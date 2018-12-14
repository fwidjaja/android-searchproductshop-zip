package com.example.ba_1963.android_searchproduct_mvp.data.product

import com.example.ba_1963.android_searchproduct_mvp.presentation.models.ResultSearchUiModel
import io.reactivex.Maybe

interface ProductRepositoryInterface {
    fun getData(q: String?, start: Int): Maybe<ResultSearchUiModel>
}