package com.cart.ecart.application

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ECartApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}
