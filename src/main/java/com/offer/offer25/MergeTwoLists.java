package com.offer.offer25;

import com.leetcode.link.ListNode;


public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1=l1,p2=l2;
        ListNode dummyHead=new ListNode(-1);
        ListNode cur=dummyHead;
        while (p1!=null&&p2!=null){
            if (p1.val <= p2.val) {
                cur.next=p1;
                p1=p1.next;
            }else {
                cur.next=p2;
                p2=p2.next;
            }
            cur=cur.next;
        }
        if (p1 == null) {
            cur.next=p2;
        }else {
            cur.next=p1;
        }

        return dummyHead.next;
    }
}
