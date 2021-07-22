package com.offer.offer09;

import java.util.Stack;

public class CQueue {

    Stack<Integer> in;
    Stack<Integer> out;
    public CQueue() {
        in=new Stack<>();
        out=new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (!out.isEmpty()){
            return out.pop();
        }else {
            if (!in.isEmpty()){
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
                return out.pop();
            }else {
                return -1;
            }
        }
    }
}
