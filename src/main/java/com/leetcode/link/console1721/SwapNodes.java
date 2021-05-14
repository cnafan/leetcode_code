package com.leetcode.link.console1721;

import com.leetcode.link.ListNode;

public class SwapNodes {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;
        ListNode fastNode= dummyNode;
        ListNode slowNode= dummyNode;
        for (int i = 0; i < k; i++) {
            fastNode=fastNode.next;
        }
        //
        ListNode k1=fastNode;
        while (fastNode!=null){
            slowNode=slowNode.next;
            fastNode=fastNode.next;
        }
        int temp=k1.val;
        k1.val=slowNode.val;
        slowNode.val=temp;
        return dummyNode.next;
    }
}
