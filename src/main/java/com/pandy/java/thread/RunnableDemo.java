package com.pandy.java.thread;

/**
 * @author Pandy
 * @date 5/6/2022
 */
public class RunnableDemo implements Runnable {
    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
        runnableDemo.run();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Creating " + Thread.currentThread().getName() + i);
        }
    }
}
