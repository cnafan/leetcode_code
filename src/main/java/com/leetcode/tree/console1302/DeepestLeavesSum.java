package com.leetcode.tree.console1302;

import com.leetcode.tree.TreeNode;

public class DeepestLeavesSum {
    private int maxDepth = -1;
    private int sumOfLeaf = 0;

    public int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return sumOfLeaf;
    }

    public void helper(TreeNode root, int depth) {
        // 终止条件
        if (root == null) return;

        // 加判断条件 非叶子节点不用计算
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                sumOfLeaf = root.val;
            } else if (depth == maxDepth) {
                sumOfLeaf += root.val;
            }
        }

        // 递归
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);

    }
}
