package com.leetcode.tree.console226;

import com.leetcode.tree.TreeNode;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return dfs(root);
    }

    TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        root.right = left;
        root.left = right;
        return root;

    }

}
