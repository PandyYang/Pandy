package com.pandy.datastructures;

/**
 * 堆的定义
 *
 * @param <T>
 */
public class MaxHeap<T> {
    private final T[] data;
    private final int count;

    public MaxHeap(int capacity) {
        data = (T[]) new Object[capacity + 1];
        count = 0;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        System.out.println(maxHeap.size());
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
