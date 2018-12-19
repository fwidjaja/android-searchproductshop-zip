package com.example.ba_1963.android_searchproduct_mvp.di.components

import com.example.ba_1963.android_searchproduct_mvp.di.modules.AppModule
import com.example.ba_1963.android_searchproduct_mvp.presentation.view.fragments.ProductFragment
import com.example.ba_1963.android_searchproduct_mvp.presentation.view.fragments.ShopFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(productFragment: ProductFragment)
    fun inject(shopFragment: ShopFragment)
}