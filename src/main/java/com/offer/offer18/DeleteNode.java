package com.offer.offer18;

import com.leetcode.link.ListNode;

public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        // 原版
//         不是尾节点
//
//
//         只有一个节点
//
//         尾节点

        // leetcode
        if (head.val == val) {
            return head.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode pre=cur;
        while (cur != null && cur.val != val) {
            pre=cur;
            cur = cur.next;
        }
        // 尾节点
        if (cur != null) {
            pre.next=cur.next;
        }
        return dummy.next;
    }
}
