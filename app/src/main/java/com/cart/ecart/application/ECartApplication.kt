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

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                Log.d("ActivityCallback", "${activity.localClassName} Created")
            }

            override fun onActivityStarted(activity: Activity) {
                Log.d("ActivityCallback", "${activity.localClassName} Started")
            }

            override fun onActivityResumed(activity: Activity) {
                Log.d("ActivityCallback", "${activity.localClassName} Resumed")
            }

            override fun onActivityPaused(activity: Activity) {
                Log.d("ActivityCallback", "${activity.localClassName} Paused")
            }

            override fun onActivityStopped(activity: Activity) {
                Log.d("ActivityCallback", "${activity.localClassName} Stopped")
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                Log.d("ActivityCallback", "${activity.localClassName} SaveInstanceState")
            }

            override fun onActivityDestroyed(activity: Activity) {
                Log.d("ActivityCallback", "${activity.localClassName} Destroyed")
            }
        })
    }
}
