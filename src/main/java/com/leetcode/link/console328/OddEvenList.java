package com.leetcode.link.console328;

import com.leetcode.link.ListNode;

import java.util.List;

/**
 * 分离节点后拼接
 */
public class OddEvenList {


    public ListNode oddEvenList2(ListNode head) {
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
