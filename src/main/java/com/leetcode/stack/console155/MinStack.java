package com.leetcode.stack.console155;

import java.util.Stack;

/**
 * 不同步栈，只有在入栈元素小于等于最小值、出栈元素等于最小值时，辅助栈才同步
 */
public class MinStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);

        if (!stack2.isEmpty()) {
            // 因为出栈时要相等时同步，所以这里为小于等于
            if (stack2.peek() >= val) {
                stack2.push(val);
            }
        } else {
            stack2.push(val);
        }
    }

    public void pop() {
        int pop = stack1.pop();
        int top = stack2.peek();
        if (top == pop) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
