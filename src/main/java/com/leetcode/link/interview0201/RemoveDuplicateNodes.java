package com.leetcode.link.interview0201;

import com.leetcode.link.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
//        int[] hash=new int[20001];
//        Arrays.fill(hash,0);
        if (head==null){
            return head;
        }
        Set<Integer> hash=new HashSet<>();
        hash.add(head.val);
        // 前驱节点
        ListNode cur=head;

        // 待删除节点
        while (cur.next!=null){
            if (hash.add(cur.next.val)){
                cur=cur.next;
            }
            else {
                cur.next=cur.next.next;
            }
        }
        cur.next=null;
        return head;
    }
}
