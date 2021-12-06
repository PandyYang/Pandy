package com.pandy.base.itguigu.juc;

/**
 * Created on 6/12/2021.
 * @author Pandy
 * 创建多线程的几种方式
 */
public class ThreadDemo {

    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        // 打印结果会交替执行
        for (int i = 0; i < 10000; i++) {
            System.out.println("我是主线程" + i);
        }
    }
}

class MyThread2 extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("我是线程" + i);
        }
    }
}

