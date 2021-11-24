package com.jay.jb_lifecycle.lifecycle.normal_use

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleService

/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/11/1
 */
class MyLifecycleService : LifecycleService() {
    init {
        lifecycle.addObserver(MyLifecycleServiceObserver())
    }
}

internal class MyLifecycleServiceObserver : LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_START) {
            Log.d("MyLifecycleService", "onStart()")
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            Log.d("MyLifecycleService", "onDestroy()")
        }
    }
}