package com.pandy.java.java8;

/**
 * @Author Pandy
 * @Date 2021/7/31 12:35
 */
public interface A {
    default void foo() {
        System.out.println("默认方法实现，加上关键字default");
    }
}
