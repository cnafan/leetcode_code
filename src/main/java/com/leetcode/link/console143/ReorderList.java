package com.leetcode.link.console143;

import com.leetcode.link.ListNode;

/**
 * 找中点 +反转+合并
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode node = slow.next;
        slow.next = null;
        ListNode first = head;
        ListNode second = reverse(node);

        while (first != null && second != null) { // ******
            // 保存h1
            ListNode first_next = first.next;
            // 保存s1
            ListNode second_next = second.next;
            first.next = second;
            first = first_next;
            second.next = first;
            second = second_next;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
