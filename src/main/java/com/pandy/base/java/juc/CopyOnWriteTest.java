package com.pandy.base.java.juc;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author Pandy
 * @Date 2021/8/8 22:34
 */
public class CopyOnWriteTest {
    private static List<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            while (i++ < 6) {
                String val = Thread.currentThread().getName() + "-" + i;
                list.add(val);
                printAll();
            }
        }
    }

    private static void printAll() {
        String value = null;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            value = (String) iterator.next();
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
