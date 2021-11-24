package com.jay.jb_lifecycle.livedata.normal_use

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/11/22
 */
class LiveDataViewModel : ViewModel() {

    //被观察者
    // Create a LiveData with a String
    private val currentNameMuteVM: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val currentNameVM: LiveData<String> = currentNameMuteVM

    fun sent() {
        //更新被观察者
        val anotherName = "Jay in VM-${(0..100).random()}"

        currentNameMuteVM.postValue(anotherName)
    }

}