package com.jay.jb_lifecycle.lifecycle.java8_default;

/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/10/27
 */
class Java8Impl implements Java8 {

    public static void main(String[] args) {
        Java8Impl java8Impl = new Java8Impl();
        //直接调用helloWorld()方法
//        java8Impl.onCreate();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {
        System.out.println("onStart");
    }
}
