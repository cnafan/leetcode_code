package com.leetcode.link.interview0207;

import com.leetcode.link.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a != null) {
                a = a.next;
            } else
                a = headB;
            if (b != null) {
                b = b.next;
            } else
                b = headA;
        }
        return b;
    }
}
