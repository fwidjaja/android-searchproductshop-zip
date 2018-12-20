package com.example.ba_1963.android_searchproduct_mvp.di.modules

import com.example.ba_1963.android_searchproduct_mvp.BuildConfig
import com.example.ba_1963.android_searchproduct_mvp.model.services.ApiService
import com.example.ba_1963.android_searchproduct_mvp.model.repositories.ProductRepository
import com.example.ba_1963.android_searchproduct_mvp.model.repositories.ProductRepositoryInterface
import com.example.ba_1963.android_searchproduct_mvp.model.repositories.ShopRepository
import com.example.ba_1963.android_searchproduct_mvp.model.repositories.ShopRepositoryInterface
import com.example.ba_1963.android_searchproduct_mvp.util.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val client = OkHttpClient().newBuilder()
        client.addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
        return client.build()
    }

    @Provides
    @Singleton
    fun provideApi() : ApiService {
        return retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(provideOkHttpClient())
                .build().create(ApiService::class.java)
    }
}