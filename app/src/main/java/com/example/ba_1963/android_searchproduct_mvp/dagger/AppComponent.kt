package com.example.ba_1963.android_searchproduct_mvp.dagger

import com.example.ba_1963.android_searchproduct_mvp.presentation.product.ProductFragment
import com.example.ba_1963.android_searchproduct_mvp.presentation.shop.ShopFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(productFragment: ProductFragment)
    fun inject(shopFragment: ShopFragment)
}