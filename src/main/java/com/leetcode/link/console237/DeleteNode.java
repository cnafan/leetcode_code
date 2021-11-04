package com.leetcode.link.console237;

import com.leetcode.link.ListNode;

public class DeleteNode {

    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
