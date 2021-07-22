package com.offer.offer06;

import com.leetcode.link.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReversePrint {
    List<Integer> list=new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        if (head.next != null) {
            reversePrint(head.next);
            list.add(head.val);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
