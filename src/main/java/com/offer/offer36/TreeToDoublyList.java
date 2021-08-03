package com.offer.offer36;

import com.leetcode.link.Node;

public class TreeToDoublyList {
    Node pre = null, head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);

        // 循环链表
        head.left=pre;
        pre.right=head;

        return head;
    }

    void dfs(Node cur) {
        if (cur == null) {
            return;
        }

        //
        dfs(cur.left);


        //最左节点，即中序遍历的第一个
        if (pre == null) {
            head=cur;
        }else {
            pre.right=cur;
        }
        cur.left=pre;
        pre=cur;



        //
        dfs(cur.right);

    }
}
