package com.leetcode_twice.link.console206;

import com.leetcode.link.ListNode;

public class ReverseList {

    // 迭代
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    // 递归

//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return null;
//        }
//        ListNode newHead = reverseList(head.next);
//        head.next.next=head;
//        head.next=null;
//        return newHead;
//    }
}
