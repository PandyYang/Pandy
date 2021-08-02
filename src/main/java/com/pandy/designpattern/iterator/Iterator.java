package com.pandy.designpattern.iterator;

/**
 * 执行递增 遍历的接口
 */
public interface Iterator {
    public abstract boolean hasNext();
    public abstract Object next();
}
