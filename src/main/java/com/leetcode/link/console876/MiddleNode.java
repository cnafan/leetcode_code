package com.leetcode.link.console876;

import com.leetcode.link.ListNode;

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        int index=0;
        while (fast!=null){
            if (index%2==1){
                slow=slow.next;
            }
            fast=fast.next;
            index++;
        }
        return slow;
    }
}
