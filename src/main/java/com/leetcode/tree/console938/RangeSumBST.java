package com.leetcode.tree.console938;

import com.leetcode.tree.TreeNode;

import java.util.TreeMap;

/**
 * 时间 O(n)
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root==null){
            return 0;
        }
        if (root.val>high){
           return rangeSumBST(root.left,low,high);
        }
        if (root.val<low){
            return rangeSumBST(root.right,low,high);
        }
        return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
    }
}
