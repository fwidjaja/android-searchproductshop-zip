package com.example.ba_1963.android_searchproduct_mvp.di.modules

import com.example.ba_1963.android_searchproduct_mvp.di.scopes.SearchScope
import com.example.ba_1963.android_searchproduct_mvp.domain.SearchUseCase
import com.example.ba_1963.android_searchproduct_mvp.model.repositories.ProductRepository
import com.example.ba_1963.android_searchproduct_mvp.model.repositories.ShopRepository
import com.example.ba_1963.android_searchproduct_mvp.model.services.ApiService
import com.example.ba_1963.android_searchproduct_mvp.presentation.presenters.SearchPresenter
import dagger.Module
import dagger.Provides

@Module
class SearchModule {

    @Provides
    @SearchScope
    fun provideSearchPresenter(apiService: ApiService) : SearchPresenter {
        return SearchPresenter(SearchUseCase(ProductRepository(apiService), ShopRepository(apiService)))
    }
}