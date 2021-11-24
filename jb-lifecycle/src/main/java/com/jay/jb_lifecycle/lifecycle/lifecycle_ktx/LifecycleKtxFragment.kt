package com.jay.jb_lifecycle.lifecycle.lifecycle_ktx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.jay.jb_lifecycle.lifecycle.normal_use.MyLifecycleFragment
import com.jay.jb_lifecycle.lifecycle.normal_use.MyLifecycleFragmentObserver

/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/10/26
 */
class LifecycleKtxFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addLifecycleObserver()
    }

    private fun addLifecycleObserver() {
        lifecycle.addObserver(MyLifecycleFragmentObserver())
    }

    override fun getLifecycle(): Lifecycle {
        return super.getLifecycle()
    }


    companion object {
        fun inject(activity: AppCompatActivity) {
            val manager = activity.supportFragmentManager
            if (manager.findFragmentByTag("MyLifecycleFragment") == null) {
                manager.beginTransaction()
                    .add(MyLifecycleFragment(), "MyLifecycleFragment")
                    .commit()
                manager.executePendingTransactions()
            }
        }
    }

}

