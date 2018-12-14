package com.example.ba_1963.android_searchproduct_mvp.presentation

import com.example.ba_1963.android_searchproduct_mvp.domain.SearchUseCase
import com.example.ba_1963.android_searchproduct_mvp.presentation.models.ResultSearchUiModel
import io.reactivex.Maybe
import javax.inject.Inject

interface BasePresenter  {
    fun onSearch(query: String?, start: Int)
    fun onLoadNextPage()
}