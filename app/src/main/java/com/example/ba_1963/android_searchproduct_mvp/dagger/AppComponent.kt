package com.example.ba_1963.android_searchproduct_mvp.dagger

import com.example.ba_1963.android_searchproduct_mvp.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}