package com.leetcode.link.console92;

import java.util.List;

public class ReverseBetween {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // use dummyNode to avoid headNode
        ListNode dummy=new ListNode(-1);
        dummy.next=head;

        // 定位到pre
        ListNode pre=dummy;
        for (int i = 0; i < left-1; i++) {
            pre=pre.next;
        }
        // 定位到left
        ListNode leftNode=pre.next;

        // 定位 right
        ListNode rightNode=pre;
        for (int i = left-1; i < right; i++) {
            rightNode=rightNode.next;
        }

        // 定位 succ
        ListNode succ=rightNode.next;


        // 切分链表（注意截断）
        pre.next=null;
        rightNode.next=null;

        // 反转链表
        reverse(leftNode);

        // 接回链表
        pre.next=rightNode;
        leftNode.next=succ;

        return dummy.next;
    }

    /**
     * reverse linked
     * @param head
     */
    public void reverse(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
    }
}
