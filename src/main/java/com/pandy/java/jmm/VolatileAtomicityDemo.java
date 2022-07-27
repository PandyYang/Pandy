package com.pandy.java.jmm;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Pandy
 * @Date 2021/7/31 9:22
 */

class MyData2 {
    volatile int number = 0;

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addPlus() {
        number++;
    }

    public void addPlus2() {
        atomicInteger.getAndIncrement();
    }
}

public class VolatileAtomicityDemo {

    public static void main(String[] args) {
        MyData2 myData2 = new MyData2();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData2.addPlus();
                    myData2.addPlus2();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t finally number value" + myData2.number);
        System.out.println(Thread.currentThread().getName() + "\t atmoic finally number value" + myData2.atomicInteger);
    }
}
