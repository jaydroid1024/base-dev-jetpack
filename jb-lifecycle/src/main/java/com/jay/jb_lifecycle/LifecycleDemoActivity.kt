package com.jay.jb_lifecycle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jay.jb_lifecycle.lifecycle.MyLifecycleMainActivity
import com.jay.jb_lifecycle.livedata.MyLiveDataMainActivity
import com.jay.jb_lifecycle.viewmodel.MyViewModelMainActivity

class LifecycleDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_demo)
    }

    fun testLifecycle(view: android.view.View) {
        startActivity(Intent(this, MyLifecycleMainActivity::class.java))
    }

    fun testLiveData(view: android.view.View) {
        startActivity(Intent(this, MyLiveDataMainActivity::class.java))
    }

    fun testViewModel(view: android.view.View) {
        startActivity(Intent(this, MyViewModelMainActivity::class.java))
    }
}