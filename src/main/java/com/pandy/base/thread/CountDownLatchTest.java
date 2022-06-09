package com.pandy.base.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: Pandy
 * @create: 2022/6/9
 *
 * 使用CountDownLatch模拟go的waitgroup
 *
 * 并行处理文件，并且等待都处理完成之后，继续执行主线程。否则一直阻塞
 **/
public class CountDownLatchTest {

    public static void main(String[] args) {

        // 有100个任务
        for (int i = 0; i < 100/5; i++) {
//            int sum = 100;
//            if (i + 5 < 100) {
//                sum = i + 4;
//            }

            CountDownLatch countDownLatch = new CountDownLatch(5);
            System.out.println("开始任务执行...");
            for (int j = 0; j < 5; j++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("线程" + Thread.currentThread().getName() + "开始执行...");
                        countDownLatch.countDown();
                    }
                }).start();
            }
            try {
                countDownLatch.await(3, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("任务全部执行完毕！");
    }
}
