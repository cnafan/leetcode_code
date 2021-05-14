package com.leetcode.link.console1290;

import java.util.ArrayList;
import java.util.List;

public class GetDecimalValue {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode cur=head;
        while (cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        int result=0;
        for (int i = list.size()-1; i >= 0; i--) {
            result+=list.get(i)*Math.pow(2,list.size()-1-i);
        }
        return result;
    }

    public int getDecimalValue2(ListNode head) {
        ListNode cur=head;
        int result=0;
        while (cur!=null){
            result=2*result+cur.val;
            cur=cur.next;
        }
        return result;
    }

    public static void main(String[] args) {
//        new GetDecimalValue().getDecimalValue();
    }
}
