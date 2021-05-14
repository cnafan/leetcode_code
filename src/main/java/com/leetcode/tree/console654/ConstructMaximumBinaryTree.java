package com.leetcode.tree.console654;

import com.leetcode.tree.TreeNode;

public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
       return construct(nums,0,nums.length);
    }

    public TreeNode construct(int[] num, int l, int r) {
        if (l == r) {
            return null;
        }
        int maxer = getMaxer(num, l, r);
        TreeNode root = new TreeNode(num[maxer]);
        construct(num, l, maxer);
        construct(num, maxer+1, r);
        return root;
    }

    public int getMaxer(int[] num, int l, int r) {
        int maxer = l;
        for (int i = l; i < r; i++) {
            if (num[maxer] > num[i]) {
                maxer = i;
            }
        }
        return maxer;
    }
}
