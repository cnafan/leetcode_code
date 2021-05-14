package com.leetcode.link.console148;

import com.leetcode.link.ListNode;

/**
 * 链表排序
 * 归并排序 O(nlogn)
 * 插入排序 O(n^2)
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {

        if (head==null){
            return head;
        }
        // 终止
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 定位中点
        ListNode fastNode=head;
        ListNode slowNode=head;
        while (fastNode!=tail){
            fastNode=fastNode.next;
            slowNode=slowNode.next;
            if (fastNode!=tail){
                fastNode=fastNode.next;
            }
        }

        // 归并
        ListNode mid=slowNode;
        ListNode list1=sortList(head,mid);
        ListNode list2=sortList(mid,tail);
        ListNode sorted=merge(list1,list2);
        return sorted;
    }

    public ListNode merge(ListNode head1,ListNode head2){
        ListNode dummyHead=new ListNode(0);
        ListNode temp=dummyHead,temp1=head1,temp2=head2;
        while (temp1!=null&&temp2!=null){
            if (temp1.val<=temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            }else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp=temp.next;
        }
        if (temp1!=null){
            temp.next=temp1;
        } else if (temp2 != null) {
            temp.next=temp2;
        }
        return dummyHead.next;
    }
}
