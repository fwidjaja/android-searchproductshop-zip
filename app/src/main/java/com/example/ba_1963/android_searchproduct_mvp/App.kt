package com.example.ba_1963.android_searchproduct_mvp

import android.app.Application
import com.example.ba_1963.android_searchproduct_mvp.di.components.AppComponent
import com.example.ba_1963.android_searchproduct_mvp.di.modules.AppModule
import com.example.ba_1963.android_searchproduct_mvp.di.components.DaggerAppComponent

class App: Application() {
    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent =  DaggerAppComponent.builder()
                .appModule(AppModule())
                .build()
    }
}