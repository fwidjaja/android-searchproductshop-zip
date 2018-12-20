package com.example.ba_1963.android_searchproduct_mvp.di.components

import com.example.ba_1963.android_searchproduct_mvp.di.modules.SearchModule
import com.example.ba_1963.android_searchproduct_mvp.di.scopes.SearchScope
import com.example.ba_1963.android_searchproduct_mvp.presentation.view.fragments.ProductFragment
import com.example.ba_1963.android_searchproduct_mvp.presentation.view.fragments.ShopFragment
import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [SearchModule::class])
@SearchScope
interface SearchComponent{
    fun inject(productFragment: ProductFragment)
    fun inject(shopFragment: ShopFragment)
}