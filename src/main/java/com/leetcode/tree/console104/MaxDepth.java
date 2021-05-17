package com.leetcode.tree.console104;

import com.leetcode.tree.TreeNode;

public class MaxDepth {


    /**
     * DFS
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }


    /**
     * dfs
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        return dfs(root,0);
    }
    int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int left=depth+1,right=depth+1;
        if (root.left != null)
            left= Math.max(depth, dfs(root.left, depth + 1));
        if (root.right != null)
            right= Math.max(depth, dfs(root.right, depth + 1));
        return Math.max(left,right);
    }
}
