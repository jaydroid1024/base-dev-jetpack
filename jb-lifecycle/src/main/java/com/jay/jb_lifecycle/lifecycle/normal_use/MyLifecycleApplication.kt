package com.jay.jb_lifecycle.lifecycle.normal_use

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.multidex.MultiDexApplication

/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/10/27
 */
class MyLifecycleApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        //饿汉式单例获取 ProcessLifecycleOwner
        ProcessLifecycleOwner.get().lifecycle.addObserver(MyLifecycleApplicationObserver(this))
    }
}


/**
 * LifecycleApplication 观察者
 * @author jaydroid
 * @version 1.0
 * @date 2021/10/26
 */

class MyLifecycleApplicationObserver(private val application: Application) :
    LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun appInResumeState() {
        Toast.makeText(application, "In Foreground", Toast.LENGTH_LONG).show()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun appInPauseState() {
        Toast.makeText(application, "In Background", Toast.LENGTH_LONG).show()
    }
}