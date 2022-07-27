package com.pandy.java.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Pandy
 * @Date 2021/8/9 21:33
 * 多线程交叉打印奇数 偶数
 * 一个方法是使用AtomicInteger实现
 * 一个是volatile关键字实现
 */
public class ThreadPrint extends Thread {

    private static final int MAX_PRINT_NUM = 100;

    private static final AtomicInteger atomicInteger = new AtomicInteger(0);
    private static volatile int count = 0;

    public static void main(String[] args) {
        ThreadPrint threadPrint = new ThreadPrint();
//        threadPrint.printAB();
        threadPrint.printCD();
    }

    /**
     * 方法1： 使用AtomicInteger实现
     */
    public void printAB() {
        new Thread(() -> {
            while (atomicInteger.get() < MAX_PRINT_NUM) {
                if (atomicInteger.get() % 2 == 0) {
                    System.out.println("num: " + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }).start();

        new Thread(() -> {
            while (atomicInteger.get() < MAX_PRINT_NUM) {
                if (atomicInteger.get() % 2 == 1) {
                    System.out.println("num:" + atomicInteger.get());
                    atomicInteger.incrementAndGet();
                }
            }
        }).start();
    }

    /**
     * 方法2： 使用volatile关键字实现
     */

    public void printCD() {
        new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 0) {
                    System.out.println("num:" + count);
                    count++;
                }
            }
        }).start();

        new Thread(() -> {
            while (count < MAX_PRINT_NUM) {
                if (count % 2 == 1) {
                    System.out.println("num: " + count);
                    count++;
                }
            }
        }).start();
    }
}
