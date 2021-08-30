package com.leetcode.recursion.console23;

import com.leetcode.link.ListNode;

/**
 * 使用归并的思想合并
 *
 * @author : cnafan
 * @date : 2021-08-27 12:12
 **/
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return process(lists, 0, lists.length - 1);
    }

    ListNode process(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        return mergeLists(process(lists, left, mid), process(lists, mid + 1, right));
    }

    public ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode next = dummy;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                next.next = p1;
                p1 = p1.next;
            } else {
                next.next = p2;
                p2 = p2.next;
            }
            next = next.next;
        }
        if (p1 == null) {
            next.next = p2;
        } else {
            next.next = p1;
        }
        return dummy.next;
    }
}
