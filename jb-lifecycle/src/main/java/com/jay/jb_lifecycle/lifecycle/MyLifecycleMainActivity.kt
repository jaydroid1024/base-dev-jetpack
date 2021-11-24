package com.jay.jb_lifecycle.lifecycle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jay.jb_lifecycle.R
import com.jay.jb_lifecycle.lifecycle.lifecycle_ktx.LifecycleKtxActivity
import com.jay.jb_lifecycle.lifecycle.lifecycle_state.LifecycleStateActivity
import com.jay.jb_lifecycle.lifecycle.normal_use.MyLifecycleActivity
import com.jay.jb_lifecycle.lifecycle.normal_use.MySdkActivity

class MyLifecycleMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_main)
    }

    fun testOnJetpack(view: android.view.View) {
        startActivity(Intent(this, MyLifecycleActivity::class.java))
    }

    fun testOnSdk(view: android.view.View) {
        startActivity(Intent(this, MySdkActivity::class.java))
    }

    fun testState(view: android.view.View) {
        startActivity(Intent(this, LifecycleStateActivity::class.java))
    }

    fun testKtx(view: android.view.View) {
        startActivity(Intent(this, LifecycleKtxActivity::class.java))
    }

}