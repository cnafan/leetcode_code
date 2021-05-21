package com.leetcode.link.console19;

import com.leetcode.link.ListNode;

import java.util.List;

/**
 * 快慢指针 ，使用虚拟头节点，避免单独处理head
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode slow=dummy,fast=dummy;

        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }

        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        //删除
        slow.next=slow.next.next;

        return dummy.next;
    }
}
