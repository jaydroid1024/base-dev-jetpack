package com.jay.jb_lifecycle.lifecycle.normal_use

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/10/27
 */
class MySdkActivity : Activity(), LifecycleOwner {

    private lateinit var lifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleRegistry = LifecycleRegistry(this)
        addLifecycleObserver()
        MySDKFragment.inject(this)
    }

    private fun addLifecycleObserver() {
        lifecycle.addObserver(MySDKActivityObserver())
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}

class MySDKActivityObserver : DefaultLifecycleObserver {

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.i("SDKActivity", "Observer onPause")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.i("SDKActivity", "Observer onResume")

    }
}