package com.pandy.java.juc.countdownloatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author: Pandy
 * @create: 2022/6/17
 *
 * 使用CountDownLatch 代替wait notify 好处就是通讯方式简单
 * 不涉及锁定 Count为0是当前线程继续执行
 **/
public class CountDownLatchTest {

    volatile List<Integer> list = new ArrayList<>();

    public void add(int i) {
        list.add(i);
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {

        CountDownLatchTest t3 = new CountDownLatchTest();

        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 start");
            if (t3.getSize() != 5) {
                try {
                    countDownLatch.await();
                    System.out.println("t2 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();

        new Thread(() -> {
            System.out.println("t1 start");
            for (int i = 0; i < 9; i++) {
                t3.add(i);
                System.out.println("add" + i);
                if (t3.getSize() == 5) {
                    System.out.println("countdown is open");
                    countDownLatch.countDown();
                }
            }
            System.out.println("t1 end");
        }).start();
    }
}
