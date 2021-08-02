package com.offer.offer30;

import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack() {
        stack=new Stack<>();
        min=new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(x);
            min.push(x);
        }else {
            if (min.peek()>x){
                stack.push(x);
                min.push(x);
            }else {
                stack.push(x);
                min.push(min.peek());
            }
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
