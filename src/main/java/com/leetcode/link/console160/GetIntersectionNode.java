package com.leetcode.link.console160;

import com.leetcode.link.ListNode;


/**
 * 相交链表
 *
 * 若两者相交 ，则a+c+b=b+c+a
 *
 * 时间复杂度:O(m+n)
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA=headB,pB=headA;
        while (pA!=pB){
            if (pA==null){
                pA=headA;
            }else {
                pA=pA.next;
            }

            if (pB==null){
                pB=headB;
            }else {
                pB=pB.next;
            }
        }
        return pA;
    }
}
