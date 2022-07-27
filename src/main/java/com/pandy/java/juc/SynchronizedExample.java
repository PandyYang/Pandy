package com.pandy.java.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Pandy
 * @Date 2021/7/19 23:39
 * <p>
 * Synchronized是基于jvm实现
 * 非公平 优先选择 jvm会自动释放死锁
 */
public class SynchronizedExample {
    public static void main(String[] args) {
        SynchronizedExample synchronizedExample = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> synchronizedExample.func1());
//        executorService.execute(() -> synchronizedExample.func1());

        // 调用不同对象得同步代码块 因此这两个线程不需要同步
        SynchronizedExample e1 = new SynchronizedExample();
        SynchronizedExample e2 = new SynchronizedExample();

        executorService.execute(() -> e1.func2());
        executorService.execute(() -> e2.func2());
    }

    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
            }
        }
    }

    public void func2() {
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i);
        }
    }
}
