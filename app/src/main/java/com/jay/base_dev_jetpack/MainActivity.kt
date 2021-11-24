package com.jay.base_dev_jetpack

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jay.jb_lifecycle.LifecycleDemoActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text: View = findViewById(R.id.tv_info)

        text.setOnClickListener {
            startActivity(Intent(this, LifecycleDemoActivity::class.java))
        }
    }

}