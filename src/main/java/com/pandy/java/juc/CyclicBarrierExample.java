package com.pandy.java.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author Pandy
 * @Date 2021/7/20 22:25
 */
public class CyclicBarrierExample {

    /**
     *  创建了5个线程 所有这些线程都是调用cb.await等待 所有这些线程一直等待
     *  直到cb中所所有线程都达到barrier时，这些线程才继续允许。
     */
    private static int SIZE = 5;
    private static CyclicBarrier cb;

    public static void main(String[] args) {
        cb = new CyclicBarrier(SIZE);
        for (int i = 0; i < SIZE; i++) {
            new InnerThread().start();
        }
    }


    static class InnerThread extends Thread {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier");
                cb.await();
                System.out.println(Thread.currentThread().getName() + " continued");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
