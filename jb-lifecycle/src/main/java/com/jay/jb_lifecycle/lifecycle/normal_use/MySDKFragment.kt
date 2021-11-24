package com.jay.jb_lifecycle.lifecycle.normal_use

import android.app.Activity
import android.app.Fragment
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
class MySDKFragment : Fragment(), LifecycleOwner {

    private lateinit var lifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        addLifecycleObserver()
    }

    private fun addLifecycleObserver() {
        lifecycle.addObserver(MySDKFragmentObserver())
    }

    companion object {
        fun inject(activity: Activity) {
            val manager = activity.fragmentManager
            if (manager.findFragmentByTag("MyLifecycleFragment") == null) {
                manager.beginTransaction()
                    .add(MySDKFragment(), "MyLifecycleFragment")
                    .commit()
                manager.executePendingTransactions()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.i("SDKFragment", " onResume")
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

    }

    override fun onPause() {
        super.onPause()
        Log.i("SDKFragment", " onPause")
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

}

class MySDKFragmentObserver : DefaultLifecycleObserver {

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.i("SDKFragment", "Observer onPause")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.i("SDKFragment", "Observer onResume")

    }
}