package com.leetcode.tree.console958;

import com.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 对于一个完全二叉树，层序遍历的过程中遇到第一个空节点之后不应该再出现非空节点
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/solution/ceng-xu-bian-li-by-dian-dao-de-hu-die-681d/
 */
public class IsCompleteTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean flag = false;
        while (!queue.isEmpty()) {

            TreeNode cur = queue.poll();
            if (flag && cur != null) {
                return false;
            }
            if (cur == null) {
                flag = true;
                continue;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new Object[]{1, 2, 3, null, 5, 6});
        TreeNode.printTree(root);
        System.out.println(new IsCompleteTree().isCompleteTree(root));
    }
}
