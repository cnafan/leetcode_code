package com.leetcode.link.offer22;


import com.leetcode.link.ListNode;

public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast=head;
        for (int i = 0; i < k; i++) {
            fast=fast.next;
        }
        ListNode slow=head;
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

}
