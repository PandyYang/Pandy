package com.pandy.base.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Pandy
 * @Date 2021/7/20 22:19
 */
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 20;
        CountDownLatch count = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.println("run...");
                count.countDown();
            });
        }
        count.await();
        System.out.println("end");
        executorService.shutdown();
    }
}
