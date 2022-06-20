package com.pandy.base.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Author Pandy
 * @Date 2021/7/20 22:19
 */
public class CountDownLatchExample {
    private static int LATCH_SIZE = 5;
    private static CountDownLatch doneSingle;

    public static void main(String[] args) {
        try {
            doneSingle = new CountDownLatch(LATCH_SIZE);

            // 创建5个任务
            for (int i = 0; i < LATCH_SIZE; i++) {
                new InnerThread().start();
            }

            System.out.println("main await begin.");
            // 主线程等待线程池中的5个任务完成
            doneSingle.await();
            System.out.println("main thread finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class InnerThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep 1000 ms");
                // 将countDownLatch的数值减1
                doneSingle.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
