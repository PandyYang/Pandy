package com.pandy.java.lock;

/**
 * @author Pandy
 * @date 6/1/2022
 */
public interface ZkLock {

    void zkLock() throws InterruptedException;

    void zkUnLock();
}
