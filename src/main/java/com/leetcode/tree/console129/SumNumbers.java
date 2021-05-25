package com.leetcode.tree.console129;

import com.leetcode.link.ListNode;
import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * dfs
 */
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }

    }

}
