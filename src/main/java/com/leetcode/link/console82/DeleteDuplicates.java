package com.leetcode.link.console82;

import com.leetcode.link.ListNode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {

        // 处理每个节点：当前节点不同于前驱，后继节点不同于当前节点，即可链接当前节点

        ListNode dummyNode=new ListNode(-101);
        dummyNode.next=head;

        ListNode pre=dummyNode;
        while (pre.next.next!=null) {
            ListNode cur = pre.next;
            ListNode succ = cur.next;
            if (pre.val!=cur.val&&succ.val!=cur.val){
                pre.next=cur;
            }else if (pre.val!=cur.val){

            }else {
                // 找到下一个不同的后继节点
                while (succ.val==cur.val&&succ.next!=null){
                    succ=succ.next;
                }
            }

        }
        ///?????????????????
        return head;
    }
}
