package com.leetcode.tree.console98;

import com.leetcode.tree.TreeNode;

/**
 * dfs必须传入一个最大值和最小值，保证当前节点的所有值要大于最小值，小于最大值
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    boolean dfs(TreeNode root,long lower,long upper) {
        if (root == null) {
            return true;
        }
        if (root.val <= lower && root.val >= upper) {
            return false;
        }
        boolean left = dfs(root.left,lower,root.val);
        boolean right = dfs(root.right,root.val,upper);
        return left&&right;
    }
}
