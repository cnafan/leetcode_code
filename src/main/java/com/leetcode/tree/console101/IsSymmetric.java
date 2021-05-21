package com.leetcode.tree.console101;

import com.leetcode.tree.TreeNode;

/**
 * 递归
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }
        boolean b1 = dfs(left.left, right.right);
        boolean b2 = dfs(left.right, right.left);
        return b1 && b2;
    }
}

