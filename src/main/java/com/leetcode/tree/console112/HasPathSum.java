package com.leetcode.tree.console112;

import com.leetcode.tree.TreeNode;

/**
 * 递归
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }
        boolean left, right;
        left = hasPathSum(root.left, targetSum - root.val);
        right = hasPathSum(root.right, targetSum - root.val);
        return left || right;
    }
}
