package com.example.ba_1963.android_searchproduct_mvp.api

import com.example.ba_1963.android_searchproduct_mvp.data.models.product.ResponseProduct
import com.example.ba_1963.android_searchproduct_mvp.data.models.shop.ResponseShop
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    // http://ace.tokopedia.com/search/product/v3?device=android&ob=23&q=baju&rows=12&source=search&start=0
    @GET("search/product/v3")
    fun searchProduct(@Query("device") device: String?,
                      @Query("ob") ob: Int,
                      @Query("q") q: String?,
                      @Query("rows") rows: Int,
                      @Query("source") source: String,
                      @Query("start") start: Int) : Observable<ResponseProduct?>

    // http://ace.tokopedia.com/search/v1/shop?device=android&q=baju&rows=12&source=search&start=0
    @GET("search/v1/shop")
    fun searchShop(@Query("device") device: String?,
                      @Query("q") q: String?,
                      @Query("rows") rows: Int,
                      @Query("source") source: String,
                      @Query("start") start: Int) : Observable<ResponseShop?>

}