package com.leetcode.link.console237;

import com.leetcode.link.ListNode;

/**
 * @author : cnafan
 * @date : 2021-11-02 21:37
 **/
public class DeleteNode2 {
    public void deleteNode(ListNode node) {
        ListNode delete=node.next;
        node.val=delete.val;
        node.next=delete.next;
    }
}
