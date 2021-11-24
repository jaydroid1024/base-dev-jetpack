package com.jay.jb_lifecycle.lifecycle.lifecycle_mini

import androidx.lifecycle.LifecycleOwner

/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/11/21
 */
interface DefaultLifecycleObserver : FullLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {}

    override fun onStart(owner: LifecycleOwner) = Unit

    override fun onResume(owner: LifecycleOwner) {}

    override fun onPause(owner: LifecycleOwner) {}

    override fun onStop(owner: LifecycleOwner) {}

    override fun onDestroy(owner: LifecycleOwner) {}

}