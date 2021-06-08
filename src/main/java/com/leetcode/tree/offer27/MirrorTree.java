package com.leetcode.tree.offer27;

import com.leetcode.tree.TreeNode;

public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        dfs(root);
        return root;
    }
    void dfs(TreeNode root){
        if (root==null){
            return;
        }
        TreeNode temp=root.left;
        root.left= root.right;
        root.right=temp;
        dfs(root.left);
        dfs(root.right);
    }
}
