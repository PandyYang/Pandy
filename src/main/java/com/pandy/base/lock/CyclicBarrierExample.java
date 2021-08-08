package com.pandy.base.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Pandy
 * @Date 2021/7/20 22:25
 */
public class CyclicBarrierExample {
//    public static void main(String[] args) {
//        final int totalThread = 20;
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < totalThread; i++) {
//            executorService.execute(() -> {
//                System.out.println("before");
//                try {
//                    cyclicBarrier.await();
//                } catch (BrokenBarrierException e) {
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("after");
//            });
//        }
//        executorService.shutdown();
//    }

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
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
