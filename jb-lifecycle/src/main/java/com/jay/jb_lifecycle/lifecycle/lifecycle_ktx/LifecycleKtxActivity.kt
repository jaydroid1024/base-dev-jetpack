package com.jay.jb_lifecycle.lifecycle.lifecycle_ktx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import com.jay.jb_lifecycle.R
import kotlinx.coroutines.launch

class LifecycleKtxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_ktx)
        lifecycleScope.launch {

        }
        lifecycle.coroutineScope.launch {

        }
    }
}