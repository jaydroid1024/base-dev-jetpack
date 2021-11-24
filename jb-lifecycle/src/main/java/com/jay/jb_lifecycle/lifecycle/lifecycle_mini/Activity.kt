package com.jay.jb_lifecycle.lifecycle.lifecycle_mini


//Activity 通过委托模式持有被委托者：LifecycleRegistry


// Lifecycle 在实现被观察者时并没有采用传统的直接继承抽象类的方式，
//而是通过组合的方式将被观察者的逻辑代码封装到了 LifecycleRegistry 类中，
//这样做的优势是符合单一原则，有利于被观察者端的代码复用，也不用破坏 Activity/Fragment 组件的继承结构
class Activity : LifecycleOwner {

    private val lifecycleRegistry: LifecycleRegistry = LifecycleRegistry(this)

    init {
        lifecycleRegistry.addObserver(ActivityObserver())
    }

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

    fun onStart() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }

    fun onStop() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
    }

}

//观察者
class ActivityObserver : LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        println("source: $source, event: $event ")
    }
}

fun main() {
    val app = Activity()
    app.onStart()
    app.onStop()
}
