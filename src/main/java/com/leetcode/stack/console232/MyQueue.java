package com.leetcode.stack.console232;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (s1.isEmpty()){
            s2.push(x);
        }
        if (s2.isEmpty()){
            s1.push(x);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int x=0;
        if (s1.isEmpty()){
            while (!s2.isEmpty()){
                x=s2.pop();
                s1.push(x);
            }
            s1.pop();
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }else {
            while (!s1.isEmpty()){
                x=s1.pop();
                s2.push(x);
            }
            s2.pop();
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return x;
    }

    /** Get the front element. */
    public int peek() {

        int x=0;
        if (s1.isEmpty()){
            while (!s2.isEmpty()){
                x=s2.pop();
                s1.push(x);
            }
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }else {
            while (!s1.isEmpty()){
                x=s1.pop();
                s2.push(x);
            }
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return x;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty()&&s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


/*
改进方法
将栈1作为输入栈，栈2作为输出栈
push时将元素压入栈1，pop时若栈2为空则pop栈1中元素同时push到栈2中，
所以输入栈的里面元素是逆队列顺序，输出栈里面元素是队列顺序
所以队列peak或者队列pop是即为O(1)复杂度

 */
