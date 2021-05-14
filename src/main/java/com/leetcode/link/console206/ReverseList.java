package com.leetcode.link.console206;

import com.leetcode.link.ListNode;

import java.util.List;

public class ReverseList {
//    public ListNode reverseList(ListNode head) {
//
//        ListNode pre=null;
//        ListNode cur=head;
//        while (cur!=null){
//            // 每一次处理节点的重新设置,会丢失下一个,所以要保存后继
//            ListNode next=cur.next;
//
//            // 设置新链表的下一节点 为 上一次循环保存的节点
//            cur.next=pre;
//
//            //保存新链表下一个节点的前驱节点
//            pre=cur;
//
//            cur=next;
//        }
//
//    }


//    public ListNode reverseList(ListNode head){
//        ListNode pre=null;
//        ListNode cur=head;
//
//        while (cur!=null){
//            ListNode next=cur.next;
//            cur.next=pre;
//            pre=cur;
//            cur=next;
//        }
//
//        return pre;
//    }


    //
    public ListNode reverseList(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
