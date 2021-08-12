package com.offer.offer55_2;

import com.leetcode.tree.TreeNode;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(dfs(root.left) - dfs(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.left), dfs(root.right)) + 1;
    }
}
