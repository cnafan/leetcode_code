package com.leetcode.tree.console110;

import com.leetcode.tree.TreeNode;

public class IsBalanced {

    /**
     * 递归
     * <p>
     * 时间复杂度：O(n^2)
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root != null) {
            return true;
        }
        return Math.abs(dfs(root.right) - dfs(root.left)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dfs(root.right), dfs(root.left)) + 1;
    }

    /**
     * 自下往上
     *
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        return helper(root) != -1;
    }

    int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        if (left == -1) {
            return -1;
        }
        int right = helper(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 2) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

}
