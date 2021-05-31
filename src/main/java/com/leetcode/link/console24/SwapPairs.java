package com.leetcode.link.console24;

import com.leetcode.link.ListNode;

public class SwapPairs {

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head==null||head.next==null) {
            return head;
        }
        ListNode second=head.next;
        head.next=swapPairs(second.next);
        second.next=head;
        return second;
    }
    /**
     * 迭代
     * @param head
     * @return
     */
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
