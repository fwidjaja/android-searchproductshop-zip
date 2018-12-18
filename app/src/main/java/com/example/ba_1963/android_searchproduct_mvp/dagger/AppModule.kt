package com.example.ba_1963.android_searchproduct_mvp.dagger

import com.example.ba_1963.android_searchproduct_mvp.BuildConfig
import com.example.ba_1963.android_searchproduct_mvp.api.Api
import com.example.ba_1963.android_searchproduct_mvp.data.product.ProductRepository
import com.example.ba_1963.android_searchproduct_mvp.data.product.ProductRepositoryInterface
import com.example.ba_1963.android_searchproduct_mvp.data.shop.ShopRepository
import com.example.ba_1963.android_searchproduct_mvp.data.shop.ShopRepositoryInterface
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
    fun provideApi() : Api {
        return retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(provideOkHttpClient())
                .build().create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideProductRepository(): ProductRepositoryInterface {
        return ProductRepository(retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(provideOkHttpClient())
                .build().create(Api::class.java))
    }

    @Provides
    @Singleton
    fun provideShopRepository(): ShopRepositoryInterface {
        return ShopRepository(retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(provideOkHttpClient())
                .build().create(Api::class.java))
    }
}