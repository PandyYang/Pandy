package com.pandy.java.concurrent;

/**
 * @Author Pandy
 * @Date 2021/7/18 8:48
 * volatile变量自增运算测试
 * <p>
 * <p>
 * volatile的语义： 1.内存可见性 2.禁止指令重排序优化
 */
public class VolatileTest {
    private static final int THREADS_COUNT = 20;
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
