package com.example.ba_1963.android_searchproduct_mvp.di.component

import android.app.Application
import com.example.ba_1963.android_searchproduct_mvp.BaseApp
import com.example.ba_1963.android_searchproduct_mvp.di.module.ActivityModule
import com.example.ba_1963.android_searchproduct_mvp.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ActivityModule::class))
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApp)
}