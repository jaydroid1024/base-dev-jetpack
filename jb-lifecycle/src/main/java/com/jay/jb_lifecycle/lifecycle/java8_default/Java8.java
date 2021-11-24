package com.jay.jb_lifecycle.lifecycle.java8_default;

/**
 * @author jaydroid
 * @version 1.0
 * @date 2021/10/27
 */
interface Java8 {

    //default 关键字修饰的方法能够向接口添加新功能方法，必须提供方法体，并确保兼容实现这个接口的之前的类
    // 不用在接口的子类中进行逐个实现该方法。可以按需实现
    //default是在需要给接口新增方法时，但是子类数量过多，或者子类没必要实现的场景下使用。 比如java8中的List接口，新增了sort()方法
    public default void onCreate() {
        System.out.println("onCreate");
    }

    //Interface abstract methods cannot have body
    void onStart();
}
