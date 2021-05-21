package com.leetcode.tree.console543;

import com.leetcode.tree.TreeNode;

/**
 * 递归
 */
public class DiameterOfBinaryTree {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max=0;
        dfs(root);
        return max;
    }
    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L_depth = dfs(root.left);
        int R_depth = dfs(root.right);
        max=Math.max(max,L_depth+R_depth);
        return Math.max(L_depth, R_depth) + 1;
    }
}
