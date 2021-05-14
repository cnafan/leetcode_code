package com.leetcode.link.console24;

import com.leetcode.link.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;

        ListNode pre=dummyNode;
        while (pre.next!=null&&pre.next.next!=null) {
            ListNode left = pre.next;
            ListNode right = left.next;
            ListNode succ = right.next;

            // 交换
            pre.next=right;
            right.next=left;
            left.next=succ;

            //
            pre=left;
        }
        return dummyNode.next;
    }
}
