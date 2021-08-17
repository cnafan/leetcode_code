package com.offer.offer59_2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

// 使用一个辅助队列用于存储队列中的最大值
public class MaxQueue {

    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        deque = new ArrayDeque<>();
    }

    // 得到队列里的最大值
    public int max_value() {
        if (deque.isEmpty()){
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        // 非空时且当前元素大于辅助队列最大值时，弹出队中小于填入值的元素，
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        // 然后压入元素
        deque.offerLast(value);
        queue.offer(value);

    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        int pop = queue.poll();
        if (deque.peekFirst()==pop){
            deque.pollFirst();
        }
        return pop;
    }
}
