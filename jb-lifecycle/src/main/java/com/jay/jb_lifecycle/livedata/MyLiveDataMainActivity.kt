package com.jay.jb_lifecycle.livedata

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.jay.jb_lifecycle.R
import com.jay.jb_lifecycle.livedata.normal_use.LiveDataViewModel
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class MyLiveDataMainActivity : AppCompatActivity() {

    private val liveDataVM: LiveDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_live_data)
        initUseLiveData()
//        liveDataVSEventBus()
//        initViewModel()

//        testMediatorLiveData()
//        testTransform()
    }


    private fun testTransform() {
        val observer = Observer<String> {
            //D/MyLiveDataMainActivity: resule: ld1-222
            //D/MyLiveDataMainActivity: resule: ld1-222
            //D/MyLiveDataMainActivity: resule: 33333
            Log.d("MyLiveDataMainActivity", "resule: $it")
        }
        val ld1 = MutableLiveData<String>()
        //创建一个新的LiveData对象，该对象在源 LiveData 值更改之前不会发出值。 如果equals()产生false则认为该值已更改
        val ld1Mapper = Transformations.distinctUntilChanged(ld1)
        ld1.observe(this, observer)
        ld1Mapper.observe(this, observer)
        ld1.postValue("ld1-111")
        ld1.postValue("ld1-222")

        val ld2 = MutableLiveData<String>()
        Transformations.switchMap(ld2) {
            ld1
        }

        val ld3 = MutableLiveData<String>()
        val map = Transformations.map(ld3) {
            Integer.parseInt(it)
        }
        val observer2 = Observer<Int> {
            Log.d("MyLiveDataMainActivity", "resule: $it")
        }
        map.observe(this, observer2)
        ld3.postValue("33333")

    }

    private fun testMediatorLiveData() {
        val observer = Observer<String> {
            //D/MyLiveDataMainActivity: resule: 1111
            //D/MyLiveDataMainActivity: resule: 2222
            Log.d("MyLiveDataMainActivity", "resule: $it")
        }
        val ld1 = MutableLiveData<String>()
        val ld2 = MutableLiveData<String>()
        val mld = MediatorLiveData<String>()//调解员
        mld.addSource(ld1, observer)
        mld.addSource(ld2, observer)

        ld1.postValue("1111")
        Handler(Looper.myLooper()!!).postDelayed({
            ld2.postValue("2222")
        }, 1000)

        mld.observe(this, observer)

    }

    private fun initViewModel() {
        //将观察者绑定到被观察者
        liveDataVM.currentNameVM.observe(this, NameObserver())
    }

    fun testInVm(view: View) {
        //更新被观察者
        liveDataVM.sent()
    }


    //观察者模式封装框架
    // Create a LiveData with a String
    private val currentNameMute: MutableLiveData<String> by lazy { MutableLiveData<String>() }

    //通过多态特性 LiveData<String> 将更新数据方法 public 收缩为 protected，对外暴露收缩后的livedata 防止篡改数据源
    private val currentName: LiveData<String> = currentNameMute

    //观察者
    // Create the observer which updates the UI.
    internal class NameObserver : Observer<String> {
        override fun onChanged(newName: String?) {
            Log.d("MyLiveDataMainActivity", "3")
            // Update the UI, in this case, a TextView.
            Log.d("MyLiveDataMainActivity", "newName: $newName")
        }
    }

    private fun initUseLiveData() {
        val observer = NameObserver()
        //将观察者绑定到被观察者
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        currentName.observe(this, observer)
        //取消观察
//        currentName.removeObserver(observer)
    }

    fun sendData(view: View) {
        //被观察者
        val anotherName = "John in Activity-${(0..100).random()}"
        //更新被观察者
        Log.d("MyLiveDataMainActivity", "1")
        currentNameMute.postValue(anotherName) //异步非阻塞
        Log.d("MyLiveDataMainActivity", "2")
        currentNameMute.value = "aaa" //同步阻塞
        Log.d("MyLiveDataMainActivity", "4")

    }

    open class A {

    }

    class B : A() {}

    private fun liveDataVSEventBus() {
        val event = B() //event

        //现观察者模式的骨架封装类
        val mld = MutableLiveData<B>() //eventbus
        //发送事件
        mld.postValue(event) //post
        //观察者
        val observer = object : Observer<A> { override fun onChanged(t: A?) {} } //subscribe
        //注册观察者
        mld.observeForever(observer) //register
        mld.observe(this,observer) //register

        //现观察者模式的骨架封装类
        val eb = EventBus.getDefault() //MutableLiveData
        //发送事件
        eb.post(event) //postValue
        //观察者
        @Subscribe fun onEvent(a: Any) {} //Observer
        //注册观察者
        eb.register(this) //observeForever
    }


}