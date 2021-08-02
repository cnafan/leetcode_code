package com.offer.offer35;

import jdk.nashorn.internal.runtime.regexp.joni.constants.TargetInfo;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

/**
 * 使用哈希表保存新旧节点关系
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy=new Node(-1);
        Node cur_new=dummy,cur_old=head;

        // 复制原链表除random部分
        while (cur_old!=null){
            Node node=new Node(cur_old.val);
            map.put(cur_old,node);

            cur_new.next=node;
            cur_new=cur_new.next;

            cur_old=cur_old.next;
        }
        // 复制random
        cur_new=dummy.next;
        while (head != null) {
            if (head.random != null) {
                cur_new.random=map.get(head.random);
            }
            cur_new=cur_new.next;
            head=head.next;
        }
        return dummy.next;
    }
}
