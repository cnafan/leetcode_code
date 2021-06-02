package com.leetcode.stack.offer09;

import com.leetcode.tree.console110.IsBalanced;

import java.util.Stack;

public class CQueue {

    private Stack<Integer> in;
    private Stack<Integer> out;
    public CQueue() {
        in=new Stack<>();
        out=new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (!out.isEmpty()) {
           return out.pop();
        }
        if (!in.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
            return out.pop();
        }
        return -1;
    }
}
