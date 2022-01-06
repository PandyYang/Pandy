package com.pandy.base.lock;

/**
 * @author Pandy
 * @date 6/1/2022
 */
public interface ZkLock {

    public void zkLock() throws InterruptedException;

    public void zkUnLock();
}
