package com.offer.offer55_1;

import com.leetcode.tree.TreeNode;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(dfs(root.left),dfs(root.right))+1;
    }
}
