package com.jay.jb_lifecycle.lifecycle.lifecycle_mini


class LifecycleRegistry(private val lifecycleOwner: LifecycleOwner) : Lifecycle() {

    private var lifecycleObserver: LifecycleObserver? = null

    private val lifecycleObservers = arrayListOf<LifecycleObserver>()

    override fun addObserver(observer: LifecycleObserver) {
        lifecycleObservers.add(observer)
        lifecycleObserver = observer
    }

    override fun removeObserver(observer: LifecycleObserver) {
        lifecycleObservers.remove(observer)
    }

    fun handleLifecycleEvent(event: Event) {
        lifecycleObservers.forEach {
            if (it is LifecycleEventObserver) {
                it.onStateChanged(lifecycleOwner, event)
            }
        }
    }

}