package com.jay.jb_lifecycle.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jay.jb_lifecycle.R

class MyViewModelMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_view_model)
    }
}