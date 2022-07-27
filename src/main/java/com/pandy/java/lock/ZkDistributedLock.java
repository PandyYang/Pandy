package com.pandy.java.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author Pandy
 * @date 6/1/2022
 */
public class ZkDistributedLock extends ZkAbstractTemplateLock{
    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public void waitZkLock() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }
}
