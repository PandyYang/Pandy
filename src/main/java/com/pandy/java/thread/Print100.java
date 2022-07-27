package com.pandy.java.thread;

/**
 * @author: Pandy
 * @create: 2022/6/20
 * <p>
 * 三个线程轮训打印1 - 100
 **/
public class Print100 {

    // 共享锁
    private static final Object lock = new Object();

    // 要打印的资源
    private static int n = 1;

    // 标志位 用于控制资源打印顺序
    private static int flag = 1;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (n <= 100) {
                    synchronized (lock) {
                        while (flag != 1) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (n != 101) {
                            System.out.println(Thread.currentThread().getName() + ": " + n++);
                        } else {
                            break;
                        }
                        flag = 2;
                        lock.notifyAll();
                    }
                }
            }
        }, "线程1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (n <= 100) {
                    synchronized (lock) {
                        while (flag != 2) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (n != 101) {
                            System.out.println(Thread.currentThread().getName() + ": " + n++);
                        } else {
                            break;
                        }
                        flag = 3;
                        lock.notifyAll();
                    }
                }
            }
        }, "线程2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (n <= 100) {
                    synchronized (lock) {
                        while (flag != 3) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (n != 101) {
                            System.out.println(Thread.currentThread().getName() + ": " + n++);
                        } else {
                            break;
                        }
                        flag = 1;
                        lock.notifyAll();
                    }
                }
            }
        }, "线程3").start();

    }
}
