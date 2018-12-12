package com.example.ba_1963.android_searchproduct_mvp.di.module

import android.app.Application
import com.example.ba_1963.android_searchproduct_mvp.BaseApp
import com.example.ba_1963.android_searchproduct_mvp.di.scope.AppScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    @AppScope
    fun provideApplication(baseApp: BaseApp): Application {
        return baseApp
    }
}