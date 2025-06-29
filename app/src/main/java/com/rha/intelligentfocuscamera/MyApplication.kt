package com.rha.intelligentfocuscamera

import android.app.Application
import android.content.Context

class MyApplication: Application() {

    init {
        MyApplication.appContext = applicationContext
    }

    companion object {
        lateinit var appContext: Context
    }
}