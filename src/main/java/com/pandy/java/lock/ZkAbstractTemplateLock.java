package com.pandy.java.lock;

/**
 * @author Pandy
 * @date 6/1/2022
 */
public abstract class ZkAbstractTemplateLock implements ZkLock {

    @Override
    public void zkLock() throws InterruptedException {
        if (tryLock()) {
            System.out.println(Thread.currentThread().getName() + "\t 占锁成功");
        } else {
            waitZkLock();
            zkLock();
        }
    }


    public abstract boolean tryLock();

    public abstract void waitZkLock() throws InterruptedException;

    @Override
    public void zkUnLock() {

    }
}
