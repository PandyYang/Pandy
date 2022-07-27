package com.pandy.java.thread;

public class TextNotify {
    public static void main(String[] args) throws InterruptedException {
        String text="hello";
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (text)
                {
                    System.out.println("同步代码块开始");
                    try {
                        text.wait();//线程等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("同步代码块结束");
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (text)
                {
                    System.out.println("线程开始唤醒");
                    text.notify();
                    System.out.println("线程结束唤醒");
                }
            }
        });
        t1.start();//开启t1线程 t1等待
        Thread.sleep(3000);//睡眠3秒 确保t1处于等待状态
        t2.start();//唤醒t1线程
    }
}
