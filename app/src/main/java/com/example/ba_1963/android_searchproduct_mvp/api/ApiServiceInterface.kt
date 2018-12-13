package com.example.ba_1963.android_searchproduct_mvp.api

import com.example.ba_1963.android_searchproduct_mvp.data.models.ResultSearchDataModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceInterface {

    @GET("search/v1/product")
    fun getSearch(@Query("q") q: String?, @Query("start") start: Int) : Single<ResultSearchDataModel?>

    /*companion object Factory {
        fun create(): ApiServiceInterface {
            val okHttpClient = OkHttpClient().newBuilder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                    })
                    .build()

            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Constants.BASE_URL)
                    .client(okHttpClient)
                    .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }*/
}