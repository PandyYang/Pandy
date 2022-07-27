package com.pandy.java.juc.aotomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Pandy
 * @create: 2022/6/25
 **/
public class AtomicIntegerTest {

    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    atomicInteger.getAndIncrement();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) Thread.yield();

        System.out.println("atomicInteger = " + atomicInteger);
    }

}


