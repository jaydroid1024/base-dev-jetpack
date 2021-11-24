package com.jay.jb_lifecycle.lifecycle.lifecycle_mini

import androidx.lifecycle.LifecycleOwner

/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/11/21
 */
interface FullLifecycleObserver : LifecycleObserver {

    fun onCreate(owner: LifecycleOwner)

    fun onStart(owner: LifecycleOwner)

    fun onResume(owner: LifecycleOwner)

    fun onPause(owner: LifecycleOwner)

    fun onStop(owner: LifecycleOwner)

    fun onDestroy(owner: LifecycleOwner)
}