package com.example.ba_1963.android_searchproduct_mvp

import android.app.Application
import com.example.ba_1963.android_searchproduct_mvp.di.component.AppComponent
import com.example.ba_1963.android_searchproduct_mvp.di.component.DaggerAppComponent

class BaseApp: Application() {

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    private fun injectMembers() = appComponent.inject(this)
}