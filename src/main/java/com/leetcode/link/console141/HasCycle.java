package com.leetcode.link.console141;

import com.leetcode.link.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形指针:
 * 时间复杂度：O(n)
 */
public class HasCycle {

    /**
     * 快慢指针
     *
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        // 起点不同的原因，无法执行循环，所以可以假设两者前方有一个虚拟节点，共同走一步就可以
        ListNode fast = head.next, slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
