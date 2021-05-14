package com.leetcode.link.console1669;

import com.leetcode.link.ListNode;

public class MergeInBetween {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 定位pre
        ListNode left=list1;
        for (int i = 0; i < a-1; i++) {
            left=left.next;
        }
        // 定位succ
        ListNode right=left;
        for (int i = a; i < b+2; i++) {
            right=right.next;
        }
        // 拼接list2
        left.next=list2;

        // 拼接list2
        ListNode cur=list2;
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next=right;
        return list1;
    }
}
