package com.jay.jb_lifecycle.lifecycle.lifecycle_mini

interface LifecycleEventObserver : LifecycleObserver {
    fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event)
}