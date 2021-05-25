package com.leetcode.link.console148;

import com.leetcode.link.ListNode;

import java.util.List;

/**
 * 链表排序
 * 归并排序 O(nlogn)
 * 插入排序 O(n^2)
 */
public class SortList {
    public ListNode sortList(ListNode head){
        return sortList(head,null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {

        if (head == null) {
            return null;
        }
        // 分割
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode fast = head, slow = head;
        // 找到中间节点的前一个所以使用如下判断fast != tail && fast.next != tail
        // 找到中间节点使用fast.next != tail && fast.next.next != tail
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
//        ListNode fastNode=head;
//        ListNode slowNode=head;
//        while (fastNode!=tail){
//            fastNode=fastNode.next;
//            slowNode=slowNode.next;
//            if (fastNode!=tail){
//                fastNode=fastNode.next;
//            }
//        }
        //

        ListNode list1 = sortList(head, slow);
        ListNode list2 = sortList(slow, tail);
        ListNode merge = merge(list1, list2);
        return merge;
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        ListNode temp1 = node1, temp2 = node2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val > temp2.val) {
                temp.next = temp2;
                temp2 = temp2.next;
            } else {
                temp.next = temp1;
                temp1 = temp1.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else {
            temp.next = temp2;
        }
        return dummyNode.next;
    }

}
