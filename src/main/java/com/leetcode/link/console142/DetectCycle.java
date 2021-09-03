package com.leetcode.link.console142;

import com.leetcode.link.ListNode;

/**
 * @author : cnafan
 * @date : 2021-08-31 17:05
 **/
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
//        ListNode slow=head,fast=head.next;
//        while (slow!=fast){
//            if (fast==null||fast.next==null){
//                return null;
//            }
//            fast=fast.next.next;
//            slow=slow.next;
//        }
        ListNode fast=head,slow=head;
        while (true){
            if (fast==null||fast.next==null ){
                return null;
            }
            fast=fast.next.next ;
            slow=slow.next;
            if (fast==slow){
                break;
            }
            System.out.println(fast.val);
        }
        fast=head;
        while (fast != slow) {
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
