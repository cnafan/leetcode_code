package com.leetcode.hash.console142;

import com.leetcode.link.ListNode;
import com.leetcode.tree.TreeNode;
import com.sun.jndi.ldap.Ber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DetectCycle {
    /**
     * 哈希
     *
     * 时间复杂度：O(n)
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> set=new HashSet<>();
        ListNode cur=head;
        while (cur!=null){
            if (set.contains(cur)){
                return cur;
            }else {
                set.add(cur);
            }
            cur=cur.next;
        }
        return null;

    }

    /**
     * 双指针
     * 视频解释 https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/yi-yan-jiu-kan-dong-de-ti-jie-shuang-zhi-4sag/
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head){
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
        }
        fast=head;
        while (fast!=slow){
            fast=fast.next ;
            slow=slow.next;
        }
        return slow;
    }
}
