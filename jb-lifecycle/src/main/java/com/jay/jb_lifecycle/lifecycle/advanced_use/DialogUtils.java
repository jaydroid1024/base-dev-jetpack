package com.jay.jb_lifecycle.lifecycle.advanced_use;

import android.app.AlertDialog;
import android.content.DialogInterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/10/27
 */
class DialogUtils {

    public static void showConfirmDialog(
            AppCompatActivity activity,
            String title, String msg, Runnable okRunnable) {

        AlertDialog dialog = new AlertDialog.Builder(activity)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        okRunnable.run();
                    }
                }).create();

        dialog.show();

        activity.getLifecycle().addObserver(new LifecycleObserver() {
            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            public void cancelDialog() {
                if (dialog.isShowing()) { // if not already dismissed by main-button tap
                    dialog.cancel();
                }
            }
        });
    }
}
