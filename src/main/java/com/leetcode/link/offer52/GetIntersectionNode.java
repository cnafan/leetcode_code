package com.leetcode.link.offer52;

import com.leetcode.link.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA=headA,pB=headB;
        while (pA!=pB){
            if (pA == null) {
                pA=headB;
            }else {
                pA=pA.next;
            }
            if (pB == null) {
                pB=headA;
            }else {
                pB=pB.next;
            }
        }
        return pA;
    }
}
