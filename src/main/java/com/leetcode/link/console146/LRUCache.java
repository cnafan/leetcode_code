package com.leetcode.link.console146;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DlinkedNode {
        int key;
        int value;
        DlinkedNode prev;
        DlinkedNode next;

        public DlinkedNode() {
        }

        public DlinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DlinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DlinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 虚拟头尾节点
        head = new DlinkedNode();
        tail = new DlinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 如果map中没有当前节点，返回-1
     * 如果有节点，将其移动到头部
     * @param key
     * @return
     */
    public int get(int key) {
        DlinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 移动到头部
        moveToHead(node);
        return node.value;
    }

    /**
     * 如果map中有key,则更新节点的值，同时移动到头部
     * 如果没有key，则添加新的节点，同时添加map中，更新size,
     *      若size超过容量，删除尾部节点，更新size，移除map中对应的
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DlinkedNode node = cache.get(key);
        if (node == null) {
            DlinkedNode newNode = new DlinkedNode(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
            if (size > capacity) {
                //超容量，删除双向链表的尾部节点
                DlinkedNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     *双向链表中添加节点，
     *      设置新节点的前驱和后继节点
     *      设置头节点的后继
     *      设置新节点后继节点的前驱
     *  @param node
     */
    private void addNode(DlinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 移除双向链表的某一节点
     *      设置当前节点前驱节点的后继
     *      设置当前节点后继节点的前驱
     * @param node
     */
    private void removeNode(DlinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 移动节点到头节点
     *      先移除节点
     *      添加到头节点
     * @param node
     */
    private void moveToHead(DlinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * 移除尾部节点，并返回删除的节点
     * @return
     */
    private DlinkedNode removeTail() {
        DlinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
