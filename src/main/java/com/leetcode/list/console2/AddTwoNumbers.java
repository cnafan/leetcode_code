package com.leetcode.list.console2;

import com.leetcode.link.ListNode;

import javax.xml.soap.Node;
import java.util.List;

public class AddTwoNumbers {
    /**
     * 模拟进位
     * 时间复杂度：O(n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null || p2 != null || add != 0) {
            int plus=add;
            if (p2 != null) {
                plus += p2.val;
            }
            if (p1 != null) {
                plus += p1.val;
            }
            add = plus / 10;
            plus %= 10;
            ListNode node = new ListNode(plus);
            node.next = null;
            cur.next = node;
            cur = node;
            if (p1 != null)
                p1 = p1.next;
            if (p2 != null)
                p2 = p2.next;
        }
        return res.next;
    }
}
