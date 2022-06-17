package com.pandy.base.juc.waitnotify;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/6/17
 *
 * 实现一个容器，提供两个方法。add size 写两个线程
 * 线程1添加10个元素到容器中，线程2实现监控元素的个数
 * 当个数到5个的时候 线程2给出提示并结束
 **/
public class WaitNotifyTest {

    /**
     * 使用wait notify进行互相通讯
     * wait会释放锁 notify不会释放锁
     *
     */

    volatile List<Integer> list = new ArrayList<>();

    public void add(int i) {
        list.add(i);
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {
        WaitNotifyTest waitNotifyTest = new WaitNotifyTest();

        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 启动");
                if (waitNotifyTest.getSize() != 5) {
                    try {
                        lock.wait();
                        System.out.println("t2结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "t2").start();

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1 启动");
                for (int i = 0; i < 9; i++) {
                    waitNotifyTest.add(i);
                    System.out.println("add" + i);
                    if (waitNotifyTest.getSize() == 5) {
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                lock.notify();
            }
        }).start();

    }

}
