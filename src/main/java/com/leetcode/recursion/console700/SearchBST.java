package com.leetcode.recursion.console700;

import com.leetcode.tree.TreeNode;

/**
 * @author : cnafan
 * @date : 2021-09-13 17:56
 **/
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
