package com.pandy.java.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Pandy
 * @Date 2021/7/19 23:45
 * <p>
 * ReentrantLock基于JDK实现
 * 可以中断
 * 默认非公平
 */
public class LockExample {

    private final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> lockExample.func());
        executorService.execute(() -> lockExample.func());
    }

    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
            }
        } finally {
            lock.unlock();
        }
    }
}
