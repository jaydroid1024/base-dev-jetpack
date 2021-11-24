package com.jay.jb_lifecycle.lifecycle.lifecycle_state;

import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/11/24
 */
class MyActivity {

    //todo 声明周期回调的最顶层方法，再往上就是AMS反射调用这里
    final void performCreate(Bundle icicle) {
        performCreate(icicle, null);
    }

    final void performCreate(Bundle icicle, PersistableBundle persistentState) {
        dispatchActivityPreCreated(icicle);
        onCreate(icicle);
        dispatchActivityPostCreated(icicle);
    }

    private void dispatchActivityPreCreated(Bundle savedInstanceState) {
//        getApplication().dispatchActivityPreCreated(this, savedInstanceState);
//        Object[] callbacks = collectActivityLifecycleCallbacks();
//        if (callbacks != null) {
//            for (int i = 0; i < callbacks.length; i++) {
//                ((Application.ActivityLifecycleCallbacks) callbacks[i]).onActivityPreCreated(this, savedInstanceState);
//            }
//        }
    }

    protected void onCreate(Bundle savedInstanceState) {
//        mFragments.dispatchCreate();
//        dispatchActivityCreated(savedInstanceState);
    }

    private void dispatchActivityCreated(Bundle savedInstanceState) {
//        getApplication().dispatchActivityCreated(this, savedInstanceState);
//        Object[] callbacks = collectActivityLifecycleCallbacks();
//        if (callbacks != null) {
//            for (int i = 0; i < callbacks.length; i++) {
//                ((Application.ActivityLifecycleCallbacks) callbacks[i]).onActivityCreated(this,
//                        savedInstanceState);
//            }
//        }
    }

    private void dispatchActivityPostCreated(Bundle savedInstanceState) {
//        Object[] callbacks = collectActivityLifecycleCallbacks();
//        if (callbacks != null) {
//            for (int i = 0; i < callbacks.length; i++) {
//                ((Application.ActivityLifecycleCallbacks) callbacks[i]).onActivityPostCreated(this,
//                        savedInstanceState);
//            }
//        }
//        getApplication().dispatchActivityPostCreated(this, savedInstanceState);
    }


    final void performStart(String reason) {
//        dispatchActivityPreStarted();
//        mInstrumentation.callActivityOnStart(this);
//        mFragments.dispatchStart();
//        dispatchActivityPostStarted();
    }

    //todo 前面的都是先 ac 后 fr 这里开始反了
    final void performPause() {
//        dispatchActivityPrePaused();
//        mFragments.dispatchPause();
//        onPause();
//        dispatchActivityPostPaused();
    }


    /*

          public State getTargetState() {
            switch (this) {
                case ON_CREATE:
                case ON_STOP:
                    return State.CREATED;
                case ON_START:
                case ON_PAUSE:
                    return State.STARTED;
                case ON_RESUME:
                    return State.RESUMED;
                case ON_DESTROY:
                    return State.DESTROYED;
                case ON_ANY:
                    break;
            }
            throw new IllegalArgumentException(this + " has no target state");
        }


        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;


        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        performCreate:
        dispatchActivityPreCreated(icicle)
        onCreate(icicle);
        dispatchActivityPostCreated(icicle)//ON_CREATE, 往上都是 INITIALIZED

        performStart:
         dispatchActivityPreStarted()
         mInstrumentation.callActivityOnStart(this);
         dispatchActivityPostStarted()//ON_START，往上都是 CREATED

         performResume:
         dispatchActivityPreResumed()
         mInstrumentation.callActivityOnResume(this);
         dispatchActivityPostResumed()//ON_RESUME，往上都是 STARTED

         performPause
         dispatchActivityPrePaused()//ON_PAUSE，往上都是 RESUMED，往后都是 STARTED todo 为什么这么设计，状态递增表示前进，状态递减表示后退，目的是尽量节省枚举的数量
         onPause()
         dispatchActivityPostPaused()

         performStop:
         dispatchActivityPreStopped()//ON_STOP ，往上都是 STARTED，往后都是 CREATED
         mInstrumentation.callActivityOnStop(this)
         dispatchActivityPostStopped()

         performDestroy:
         dispatchActivityPreDestroyed()//ON_DESTROY ，往上都是 CREATED，往后都是 DESTROYED
         onDestroy()
         dispatchActivityPostDestroyed()




     */


}
