package com.leetcode.link.console61;

import com.leetcode.link.ListNode;

/**
 * 找到倒数第k个元素，把后面的元素拼接到链表头
 *
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        // 求链表长度
        int len = 0;
        ListNode count = head;
        while (count != null) {
            len++;
            count = count.next;
        }
        if (len == 0 || len == 1 || k == 0 || k % len == 0) {
            return head;
        }

        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        // 找到倒数第k+1个元素
        ListNode fast=head,slow=head;
        for (int i = 0; i < k % len; i++) {
            fast=fast.next;
        }
        while (fast.next != null) {
            fast=fast.next;
            slow=slow.next;
        }
        ListNode start=slow.next;
        ListNode end= start;
        while (end.next!=null){
            end=end.next;
        }



        slow.next=null;
        end.next=head;
        dummy.next=start;
        return dummy.next;


//
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode pre = dummy;
//        for (int i = 0; i <= k % len; i++) {
//            pre = pre.next;
//        }
//        ListNode start = pre.next;
//        ListNode end = start;
//        pre.next = null;
//        while (end.next != null) {
//            end = end.next;
//        }
//        dummy.next = start;
//        end.next = head;
//        return dummy.next;
    }
}
