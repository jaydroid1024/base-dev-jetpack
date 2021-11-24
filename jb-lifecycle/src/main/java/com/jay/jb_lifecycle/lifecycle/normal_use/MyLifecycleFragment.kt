package com.jay.jb_lifecycle.lifecycle.normal_use

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/10/26
 */
class MyLifecycleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addLifecycleObserver()
    }

    private fun addLifecycleObserver() {
        lifecycle.addObserver(MyLifecycleFragmentObserver())
    }

    override fun getLifecycle(): Lifecycle {
        return super.getLifecycle()
    }


    companion object {
        fun inject(activity: AppCompatActivity) {
            val manager = activity.supportFragmentManager
            if (manager.findFragmentByTag("MyLifecycleFragment") == null) {
                manager.beginTransaction()
                    .add(MyLifecycleFragment(), "MyLifecycleFragment")
                    .commit()
                manager.executePendingTransactions()
            }
        }
    }

}


/**
 * MyLifecycleFragment 观察者
 * @author jaydroid
 * @version 1.0
 * @date 2021/10/26
 */

class MyLifecycleFragmentObserver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectListener() {
        Log.i("MyLifecycleFragment", "onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun disconnectListener() {
        Log.i("MyLifecycleFragment", "onPause")
    }

    //任何一个生命周期方法都会回调
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny() {
        Log.i("MyLifecycleFragment", "onAny")
    }
}
