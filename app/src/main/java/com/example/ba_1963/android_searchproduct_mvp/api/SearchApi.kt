package com.example.ba_1963.android_searchproduct_mvp.api

import com.example.ba_1963.android_searchproduct_mvp.data.models.ResultSearchDataModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    @GET("search/v1/product")
    fun getSearch(@Query("q") q: String?, @Query("start") start: Int) : Single<ResultSearchDataModel?>
}