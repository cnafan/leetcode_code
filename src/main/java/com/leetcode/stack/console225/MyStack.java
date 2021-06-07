package com.leetcode.stack.console225;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 一个队列用于保持栈的属性，即队头元素即为栈顶元素，
 * 另一个队列作为辅助队列，每次入栈都让原队列元素出队并入辅助队列
 */
public class MyStack {
    private Queue<Integer> in, out;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        in.offer(x);
        while (!out.isEmpty()) {
            in.add(out.poll());
        }
        Queue<Integer> temp = out;
        out = in;
        in = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return out.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return out.element();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return out.isEmpty();
    }
}
