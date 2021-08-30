package com.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/solution/lru-ce-lue-xiang-jie-he-shi-xian-by-labuladong/
 *
 * 双向链表+HashMap
 *
 * 双向链表用于存储先后顺序，头部存放最新使用的
 * map存放(key,node)；
 * 通过map可以实现o(1)的查找节点位置，而双向链表可以实现O(1)的插入和删除操作
 * 结合之后就可以实现O(1)的增删查改的LRU
 *
 * Java中已经有现成的实现类 --- LinkedHashMap 使用LinkedHashMap实现方式见底部
 *
 *
 * @author : cnafan
 * @date : 2021-08-24 16:19
 **/
public class LRUCache {
    // 链表节点
    class Node {
        private int key, val;
        private Node next, pre;

        public Node() {
        }

        public Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    // 双向链表
    class DoubleLinkedList {
        private Node dummyHead;
        private Node dummyTail;

        public DoubleLinkedList() {
            dummyHead = new Node();
            dummyTail = new Node();
            dummyTail.pre = dummyHead;
            dummyHead.next = dummyTail;
        }

        // 最近使用的节点
        public void addFirst(Node node) {
            node.next = dummyHead.next;
            node.pre = dummyHead;
            dummyHead.next.pre = node;
            dummyHead.next = node;
        }

        // 移除一个节点，时间复杂度O(1)
        public void remove(Node node) {
            Node next = node.next;
            Node pre = node.pre;
            next.pre = pre;
            pre.next = next;
        }

        // 移除最久使用的
        public Node removeLast() {
            Node last = dummyTail.pre;
            remove(last);
            return last;
        }

        // 将节点移至最新使用
        public void MoveToFirst(Node node){
            remove(node);
            addFirst(node);
        }
    }

    private DoubleLinkedList linkedList;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        linkedList = new DoubleLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            linkedList.MoveToFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 如果map中存在，则将链表中的节点删除，然后重新添加
        if (map.containsKey(key)) {
            linkedList.remove(map.get(key));
        } else {
            // 如果不存在，看是不是已满，若是那就删除最后一个然后重新添加。
            if (map.size() == capacity) {
                Node last = linkedList.removeLast();
                map.remove(last.key);
            }
        }
        Node node = new Node(key, value);
        linkedList.addFirst(node);
        map.put(key, node);
    }

}


/**
// 重写lru方法
class LRUCacheByLhm {
    public LinkedHashMap<Integer, Integer> cacheMap;

    public LRUCacheByLhm(int capacity) {
 // true 表示按照访问顺序排序，最近访问的放在头部，
        this.cacheMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return super.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cacheMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cacheMap.put(key, value);
    }
}
*/
