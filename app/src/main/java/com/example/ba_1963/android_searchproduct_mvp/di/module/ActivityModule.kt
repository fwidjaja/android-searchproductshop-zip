package com.example.ba_1963.android_searchproduct_mvp.di.module

import com.example.ba_1963.android_searchproduct_mvp.di.scope.ActivityScope
import com.example.ba_1963.android_searchproduct_mvp.search.SearchContract
import com.example.ba_1963.android_searchproduct_mvp.search.SearchPresenter
import dagger.Module
import dagger.Provides

@ActivityScope
@Module
class ActivityModule {

    @ActivityScope
    @Provides
    internal fun provideSearchPresenter(searchPresenter: SearchPresenter): SearchContract.Presenter {
        return searchPresenter
    }
}