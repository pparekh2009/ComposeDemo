package com.example.composedemo.accessibility

import android.app.Application
import com.example.composedemo.accessibility.data.AppContainer
import com.example.composedemo.accessibility.data.AppContainerImpl

class JetnewsApplication : Application() {

    // AppContainer instance used by the rest of classes to obtain dependencies
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)
    }
}