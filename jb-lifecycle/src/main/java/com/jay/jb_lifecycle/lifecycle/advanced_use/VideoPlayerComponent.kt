package com.jay.jb_lifecycle.lifecycle.advanced_use

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent


/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/10/27
 */
class VideoPlayerComponent : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {

        //initializePlayer()

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {

        //releasePlayer()

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {

        // releasePlayer()

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {

        //initializePlayer()
    }

}