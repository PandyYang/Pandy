package com.pandy.base.jmm;


import java.util.concurrent.TimeUnit;

/**
 * @Author Pandy
 * @Date 2021/7/31 9:08
 */

class MyData {
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }
}

public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myData.addTo60();

            System.out.println(Thread.currentThread().getName() + "\t update number value");
        }, "AAA").start();

        while (myData.number == 0) {}

        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}
