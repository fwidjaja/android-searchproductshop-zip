package com.example.ba_1963.android_searchproduct_mvp.api

import com.example.ba_1963.android_searchproduct_mvp.BuildConfig
import com.example.ba_1963.android_searchproduct_mvp.model.data.ResultSearchDataModel
import com.example.ba_1963.android_searchproduct_mvp.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    companion object {
        private var mInstance: API? = null
        val instance: API
            get() {
                if (mInstance == null) {
                    val okHttpClient = OkHttpClient().newBuilder()
                            .addInterceptor(HttpLoggingInterceptor().apply {
                                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                            })
                            .build()

                    mInstance = Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(Constants.BASE_URL)
                            .client(okHttpClient)
                            .build().create(API::class.java)
                }
                return mInstance!!
            }
    }

    @GET("search/v1/product")
    fun getSearch(@Query("q") q: String?, @Query("start") start: Int) : Call<ResultSearchDataModel?>
}