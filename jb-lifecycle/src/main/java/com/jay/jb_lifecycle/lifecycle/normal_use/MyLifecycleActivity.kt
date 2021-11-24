package com.jay.jb_lifecycle.lifecycle.normal_use

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.jay.jb_lifecycle.R


/**
 *
 * @author jaydroid
 * @version 1.0
 * @date 2021/10/26
 */
class MyLifecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.activity_lifecycle)
        addLifecycleObserver()

        setFragment()
        setService()
        setView()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
        stopService()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    private fun stopService() {
        val intent = Intent(this, MyLifecycleService::class.java)
        stopService(intent)
    }

    private fun addLifecycleObserver() {
        lifecycle.addObserver(MyLifecycleActivityObserver())
    }

    private fun setView() {
        val view: MyLifecycleView = findViewById(R.id.view_info)
        view.alpha = 0.5f
        view.setBackgroundColor(Color.CYAN)
    }


    private fun setService() {
        val intent = Intent(this, MyLifecycleService::class.java)
        startService(intent)
    }


    private fun setFragment() {
        MyLifecycleFragment.inject(this)
    }

    companion object {
        const val TAG = "Life_Owner"
    }

}


/**
 * MyLifecycleMainActivity 观察者
 * DefaultLifecycleObserver 所有方法将在 [LifecycleOwner] 的生命周期回调方法被调用之前被调用。
 * LifecycleEventObserver onStateChanged 方法在当状态转换事件发生时调用。
 *  如果一个类同时实现了这个接口和LifecycleEventObserver ，则首先调用DefaultLifecycleObserver方法，
 *  然后调用LifecycleEventObserver.onStateChanged(LifecycleOwner, Lifecycle.Event)
 *  如果一个类实现了这个接口并且同时使用了OnLifecycleEvent ，那么注解将被忽略。
 *
 * @author jaydroid
 * @version 1.0
 * @date 2021/10/26
 */
class MyLifecycleActivityObserver : DefaultLifecycleObserver, LifecycleEventObserver {

    override fun onCreate(owner: LifecycleOwner) {
        Log.d(TAG, "onCreate")
    }

    override fun onStart(owner: LifecycleOwner) {
        Log.d(TAG, "onStart")
    }

    override fun onResume(owner: LifecycleOwner) {
        Log.d(TAG, "onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)//
    fun onResume2() {
        Log.d(TAG, "onResume2")
    }

    override fun onPause(owner: LifecycleOwner) {
        Log.d(TAG, "onPause")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d(TAG, "onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        Log.d(TAG, "onDestroy")
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.d(TAG, "onStateChanged,event:$event")
    }

    companion object {
        const val TAG = "Life_Observer"
    }
}
