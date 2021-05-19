package com.leetcode.stack.console234;

import com.leetcode.link.ListNode;
import com.leetcode.tree.TreeNode;

import java.util.List;
import java.util.Stack;

public class IsPalindrome {

    /**
     * 快慢指针,找到中点，反转前半部分，通过比较反转后的部分和原后半部分来判断是否回文
     *
     * 时间复杂度：O(n)
     * 空间复杂度: O(1)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode first_end = slow;
        // 反转链表
        ListNode second_start = reverse(slow.next);

        // 判断回文
        ListNode p1 = head;
        ListNode p2 = second_start;
        while (p2 != null) {
            if (p2.val != p1.val) {
                return false;
            }
            p2 = p2.next;
            p1 = p1.next;
        }
        return true;
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


    /**
     * 栈
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        System.out.println(len);
        cur = head;
        for (int i = 0; i < len / 2; i++) {
            stack.push(cur.val);
            cur = cur.next;
        }
        if (len % 2 == 1) {
            cur = cur.next;
        }

        for (int i = 0; i < len / 2; i++) {
            int node = stack.pop();
            if (node != cur.val) {
                return false;
            }
            cur = cur.next;
        }
        return stack.isEmpty();
    }
}
