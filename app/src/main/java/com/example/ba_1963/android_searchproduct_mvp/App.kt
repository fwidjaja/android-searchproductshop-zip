package com.example.ba_1963.android_searchproduct_mvp

import android.app.Application
import com.example.ba_1963.android_searchproduct_mvp.dagger.AppComponent
import com.example.ba_1963.android_searchproduct_mvp.dagger.AppModule
import com.example.ba_1963.android_searchproduct_mvp.dagger.DaggerAppComponent

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