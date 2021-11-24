package com.jay.jb_lifecycle.livedata.normal_use

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/11/22
 */
class LiveDataTest {
}

fun main() {
    //被观察者
    // Create a LiveData with a String
    val currentName: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    //观察者
    // Create the observer which updates the UI.
    val nameObserver = Observer<String> { newName ->
        // Update the UI, in this case, a TextView.
        println("newName: $newName")
    }

    //将观察者绑定到被观察者
    // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
    currentName.observeForever(nameObserver)


    //更新被观察者
    val anotherName = "John Doe"
    currentName.value = anotherName
}