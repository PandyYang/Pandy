package com.pandy.designpattern.iterator;

/**
 * 执行递增 遍历的接口
 */
public interface Iterator {
    boolean hasNext();

    Object next();
}
