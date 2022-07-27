package com.pandy.java.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Pandy
 * @date 6/1/2022
 */
public class OrderService {
    private final OrderNumberCreateUtil orderNumberCreateUtil = new OrderNumberCreateUtil();

    private final Lock lock = new ReentrantLock();

    public String getOrderNumber() {
        lock.lock();
        try {
            return orderNumberCreateUtil.getOrderNumber();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    /**
     * 当前50个线程获取订单号 会出现两个为1
     * @return
     */
//    public String getOrderNumber() {
//        return orderNumberCreateUtil.getOrderNumber();
//    }
}
