package com.jay.jb_lifecycle.lifecycle.lifecycle_state

import android.app.Activity
import android.app.Application
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.jay.jb_lifecycle.R

class LifecycleStateActivity : AppCompatActivity() {
    val TAG = "LifecycleStateActivity"
    //D/LifecycleStateActivity: onCreate
    //D/LifecycleStateActivity: onCreate:currentState: INITIALIZED
    //D/LifecycleStateActivity: onStart
    //D/LifecycleStateActivity: onStart:currentState: CREATED
    //D/LifecycleStateActivity: onResume
    //D/LifecycleStateActivity: onResume:currentState: STARTED

    //D/LifecycleStateActivity: onPause
    //D/LifecycleStateActivity: onPause:currentState: STARTED
    //D/LifecycleStateActivity: onStop
    //D/LifecycleStateActivity: onStop:currentState: CREATED
    //D/LifecycleStateActivity: onDestroy
    //D/LifecycleStateActivity: onDestroy:currentState: DESTROYED

    //todo state: 状态表示生命周期方法的起点或终点；event:一次性事件
    // onCreate\onStart\onResume 前进流程中状态表示对应生命周期方法的终点
    // onPause\onStop\onDestroy 后退流程中状态表示对应生命周期方法的起点


    //D/LifecycleStateActivity: onCreate
    //D/LifecycleStateActivity: onCreate:currentState: INITIALIZED
    //D/LifecycleStateActivity: onStateChanged: ON_CREATE
    //D/LifecycleStateActivity: onStateChanged: ON_CREATE:currentState: CREATED

    //D/LifecycleStateActivity: onStart
    //D/LifecycleStateActivity: onStart:currentState: CREATED
    //D/LifecycleStateActivity: onStateChanged: ON_START
    //D/LifecycleStateActivity: onStateChanged: ON_START:currentState: STARTED

    //D/LifecycleStateActivity: onResume
    //D/LifecycleStateActivity: onResume:currentState: STARTED //todo onResume 时 performOnResume 还没结束
    //D/LifecycleStateActivity: onStateChanged: ON_RESUME
    //D/LifecycleStateActivity: onStateChanged: ON_RESUME:currentState: RESUMED  //todo 此时执行到了 dispatchActivityPostResumed

    //todo 回退流程是在 dispatchActivityPreResumed 执行， 前进流程是在 dispatchActivityPostResumed 执行
    //D/LifecycleStateActivity: onStateChanged: ON_PAUSE
    //D/LifecycleStateActivity: onStateChanged: ON_PAUSE:currentState: STARTED
    //D/LifecycleStateActivity: onPause
    //D/LifecycleStateActivity: onPause:currentState: STARTED

    //D/LifecycleStateActivity: onStateChanged: ON_STOP
    //D/LifecycleStateActivity: onStateChanged: ON_STOP:currentState: CREATED
    //D/LifecycleStateActivity: onStop
    //D/LifecycleStateActivity: onStop:currentState: CREATED

    //D/LifecycleStateActivity: onStateChanged: ON_DESTROY
    //D/LifecycleStateActivity: onStateChanged: ON_DESTROY:currentState: DESTROYED
    //D/LifecycleStateActivity: onDestroy
    //D/LifecycleStateActivity: onDestroy:currentState: DESTROYED


    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_state)
        logState("onCreate")
        lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                Log.d(TAG, "onStateChanged: " + event.name)
                Log.d(TAG, "onStateChanged: $event:currentState: ${lifecycle.currentState}")
            }
        })

    }

    val life = object : Application.ActivityLifecycleCallbacks {
        /**
         * Called when the Activity calls [super.onCreate()][Activity.onCreate].
         */
        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
            TODO("Not yet implemented")
        }

        override fun onActivityPreCreated(activity: Activity, savedInstanceState: Bundle?) {
            super.onActivityPreCreated(activity, savedInstanceState)
        }

        /**
         * Called when the Activity calls [super.onStart()][Activity.onStart].
         */
        override fun onActivityStarted(activity: Activity) {
            TODO("Not yet implemented")
        }

        /**
         * Called when the Activity calls [super.onResume()][Activity.onResume].
         */
        override fun onActivityResumed(activity: Activity) {
            TODO("Not yet implemented")
        }

        /**
         * Called when the Activity calls [super.onPause()][Activity.onPause].
         */
        override fun onActivityPaused(activity: Activity) {
            TODO("Not yet implemented")
        }

        /**
         * Called when the Activity calls [super.onStop()][Activity.onStop].
         */
        override fun onActivityStopped(activity: Activity) {
            TODO("Not yet implemented")
        }

        /**
         * Called when the Activity calls
         * [super.onSaveInstanceState()][Activity.onSaveInstanceState].
         */
        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            TODO("Not yet implemented")
        }

        /**
         * Called when the Activity calls [super.onDestroy()][Activity.onDestroy].
         */
        override fun onActivityDestroyed(activity: Activity) {
            TODO("Not yet implemented")
        }

    }

    private fun logState(life: String) {
        Log.d(TAG, life)
        Log.d(TAG, "$life:currentState: ${lifecycle.currentState}")
    }

    override fun onRestart() {
        super.onRestart()
        logState("onRestart")
    }

    override fun onStart() {
        super.onStart()
        logState("onStart")
    }

    override fun onResume() {
        super.onResume()
        logState("onResume")
    }

    override fun onPause() {
        super.onPause()
        logState("onPause")
    }

    override fun onStop() {
        super.onStop()
        logState("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logState("onDestroy")
    }
}