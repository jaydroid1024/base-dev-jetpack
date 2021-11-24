package com.jay.jb_lifecycle.lifecycle.normal_use

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner

/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/11/2
 */

class MyLifecycleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {
    init {
        addOnAttachStateChangeListener(object : OnAttachStateChangeListener {

            override fun onViewAttachedToWindow(v: View?) {
                Log.d("MyLifecycleView", "onViewAttachedToWindow")
                findViewTreeLifecycleOwner()?.lifecycle
                    ?.addObserver(object : LifecycleEventObserver {
                        override fun onStateChanged(
                            source: LifecycleOwner,
                            event: Lifecycle.Event
                        ) {
                            Log.d("MyLifecycleView", "onStateChanged：source:$source, event: $event")
                        }
                    })
            }

            override fun onViewDetachedFromWindow(v: View?) {
                Log.d("MyLifecycleView", "onViewDetachedFromWindow")

            }

        })

    }
}
