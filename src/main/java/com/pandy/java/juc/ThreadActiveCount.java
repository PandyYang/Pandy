package com.pandy.java.juc;

import java.util.concurrent.TimeUnit;

public class ThreadActiveCount {
    public static void main(String[] args) throws InterruptedException {
        // IDEA 中的线程除了主线程之外还有一个Ctrl-Break的监控线程
        Thread.currentThread().getThreadGroup().list();
        System.out.println(Thread.activeCount());

        TimeUnit.SECONDS.sleep(1);
        System.out.println("TimeUnit用来替代Thread.sleep()");
    }
}
