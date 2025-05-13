package com.eco_easy

import android.app.Application
import com.eco_easy.app.di.initKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}