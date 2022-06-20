package com.pandy.algorithm.LRUCache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LRU<K, V> implements Iterable<K> {

    private Node head;
    private Node tail;
    private HashMap<K, Node> map;
    private int maxSize;


    private class Node {
        Node pre;
        Node next;
        K k;
        V v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public LRU(int maxSize) {
        this.maxSize = maxSize;
        this.map = new HashMap<>(maxSize * 4 / 3);

        head = new Node(null, null);
        tail = new Node(null, null);

        // 构建双向链表
        head.next = tail;
        tail.pre = head;
    }

    public V get(K key) {
        if (!map.containsKey(key)){
            return null;
        }

        Node node = map.get(key);
        return (V) node;
    }

    private void unlink(Node node) {
        Node pre = node.pre; // 找到前一个节点
        node.pre = node.next; // 将前一个节点指向下一个节点
        node.next = pre; //
    }

    private void appendHead(Node node) {
        node.next = head.next;
        head.next = node;
    }

    private Node removeTail() {
        Node node = tail.pre;
        node.pre = tail;
        return node;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super K> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<K> spliterator() {
        return Iterable.super.spliterator();
    }
}
