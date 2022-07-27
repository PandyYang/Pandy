package com.pandy.java.thread;

/**
 * @author Pandy
 * @date 5/6/2022
 */
public class ThreadDemo extends Thread {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.setName("test1");
        threadDemo.start();

        ThreadDemo threadDemo2 = new ThreadDemo();
        threadDemo2.setName("test2");
        threadDemo2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Creating " + Thread.currentThread().getName() + i);
        }
    }
}
