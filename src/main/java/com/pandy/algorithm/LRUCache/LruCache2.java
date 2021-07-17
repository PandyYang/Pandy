package com.pandy.algorithm.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Pandy
 */
// 继承LinkedHashMap
public class LruCache2<K,V> extends LinkedHashMap<K,V> {

    // 缓存容量
    private int size;

    public LruCache2(int initialCapacity, float loadFactor) {
        // 这里true是关键
        // true: 按照访问的顺序存储元素--> put、get都会将最近使用的元素存储在链表尾部
        // false: 按照put的顺序存储元素
        super(initialCapacity, loadFactor, true);
        this.size = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 容量超过缓存设置的容量后, 移除最老的元素
        return size() > size;
    }
}
// 原来是 1,1 2,2, 3,3,    put一个2,4,  会变成1,1 3,3 2,4
