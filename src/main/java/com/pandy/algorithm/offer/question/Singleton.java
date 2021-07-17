package com.pandy.algorithm.offer.question;

import java.awt.*;

/**
 * 设计一个类 我们只能生成该类的一个实例
 */

// 饿汉式 线程安全
class A {
    private static final A instance = new A();
    private A() {

    }

    public static A getInstance() {
        return instance;
    }
}

// 懒汉式 线程安全写法
class B{
    private static volatile B instance = null;

    private B() {

    }

    public static B getInstance() {
        if (instance == null) {
            synchronized (B.class) {
                if (instance == null) {
                    instance = new B();
                }
            }
        }
        return instance;
    }
}

// 静态内部类方式 线程安全
class C {
    private C() {

    }

    public static C getInstance() {
        return CHolder.INSTANCE;
    }

    private static class CHolder{
        private static final C INSTANCE = new C();
    }
}

// 饿汉式 调用效率高不能延时加载
class ImageLoader {
    private static ImageLoader instance = new ImageLoader();
    // 私有构造器
    private ImageLoader(){}

    public static ImageLoader getInstance() {
        return instance;
    }
}

// 懒汉式
class Hungary{
    // 类初始化时 不初始化这个对象 真正用的时候再创建
    private static Hungary instance;

    private Hungary(){ }

    public static synchronized Hungary getInstance() {
        if (instance == null) {
            instance = new Hungary();
        }
        return instance;
    }
}

//双重校验锁模式 由于jvm底层模型的原因 不建议使用
class DoubleCheck {
    private volatile static DoubleCheck instance;
    private DoubleCheck(){ }
    private static DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (DoubleCheck.class) {
                if (instance == null) {
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}

//静态内部类
class StaticInnerClass{
    private static class InnerClass{
        private static final StaticInnerClass instance = new StaticInnerClass();
    }

    private StaticInnerClass() {}

    public static StaticInnerClass getInstance() {
        return InnerClass.instance;
    }
}

//枚举类
enum EnumClass {
    INSTANCE;

    public void getInstance() {

    }
}