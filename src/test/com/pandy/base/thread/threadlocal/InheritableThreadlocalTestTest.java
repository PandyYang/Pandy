package com.pandy.base.thread.threadlocal;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author: Pandy
 * @create: 2022/7/5
 **/
public class InheritableThreadlocalTestTest {

    @Test
    public void testInheritableThreadLocal() {
        final InheritableThreadLocal<Object> tl = new InheritableThreadLocal<>();
        tl.set("test demo");
        new Thread(() -> {
            System.out.println("t1的值:" + tl.get());
            new Thread(() -> {
                System.out.println("=========================");
                System.out.println("t1的值:" + tl.get());
            });
        }).start();
    }

    @Test
    public void parentAndSonThreadDemo() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        inheritableThreadLocal.set("thread local的值是: hello inheritableThreadLocal");
        threadLocal.set("thread local的值是: hello");

        new Thread(() -> {
            System.out.println("子线程获取的值是：");
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            System.out.println("=========================");

            new Thread(() -> {
                System.out.println("grandson线程获取到的值是: ");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
            }).start();
        }).start();
    }

}
