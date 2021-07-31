package com.pandy.base.java.jmm;

/**
 * @Author Pandy
 * @Date 2021/7/31 9:22
 */

class MyData2 {
    volatile int number = 0;

    public void addPlus() {
        number++;
    }
}

public class VolatileAtomicityDemo {

    public static void main(String[] args) {
        MyData2 myData2 = new MyData2();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData2.addPlus();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t finally number value" + myData2.number);
    }
}
