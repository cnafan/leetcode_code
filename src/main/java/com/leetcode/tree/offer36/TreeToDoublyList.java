package com.leetcode.tree.offer36;

import com.leetcode.link.Node;
import com.leetcode.tree.console105.BuildTree;

/**
 * 二叉搜索树与双向链表
 * 二叉搜索树一般会用中序遍历，dfs
 * 如果使用递归生成双向链表，即只考虑当前节点和前一节点的链接关系，因此只要递归时传入pre，递归完更新pre=cur
 *
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/
 */
public class TreeToDoublyList {

    Node head = null, pre = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);

        // 设置循环链表
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        //
        if (pre != null) {
            pre.right = cur;// 链接pre和cur
        } else {
            head = cur;// 当找到最小的节点时
        }
        cur.left = pre;// 链接pre和cur
        pre=cur;// pre更新
        //
        dfs(cur.right);
    }
}
