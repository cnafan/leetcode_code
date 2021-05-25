package com.leetcode.link.console83;

import com.leetcode.link.ListNode;

/**
 * 两个指针，一个为重复部分的第一个节点，另一个为重复节点的下一个，
 * 找到这两个指针后，重新链接
 * 第一个指针后移到刚才的节点，另一个指针继续寻找
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode start = head, end = head;
        while (end != null) {
            // 找到不同的节点
            while (end != null && start.val == end.val) {
                end = end.next;
            }
            start.next = end;
            start = end;
            if (end != null)
                end = end.next;
        }
        return head;
    }
}
