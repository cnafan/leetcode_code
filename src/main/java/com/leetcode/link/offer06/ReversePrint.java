package com.leetcode.link.offer06;

import com.leetcode.link.ListNode;

import java.util.Stack;

public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        ListNode cur=head;
        while (cur!=null){
            stack.push(cur.val);
            cur=cur.next;
        }
        int[] result=new int[stack.size()];
        int index=0;
        while (!stack.isEmpty()){
            result[index++]=stack.pop();
        }
        return result;
    }
}
