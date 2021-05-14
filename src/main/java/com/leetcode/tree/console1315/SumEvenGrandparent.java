package com.leetcode.tree.console1315;

import com.leetcode.tree.TreeNode;

public class SumEvenGrandparent {
    private int res = 0;

    // bfs 版本
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return res;
        }
        if (root.val % 2 == 0) {
            if (root.left != null) {
                res += root.left.left == null ? 0 :root.left.left.val;
                res += root.left.right == null ? 0 : root.left.right.val;
            }
            if (root.right != null) {
                res += root.right.left == null ? 0 : root.right.left.val;
                res += root.right.right == null ? 0 : root.right.right.val;
            }
        }
        sumEvenGrandparent(root.left);
        sumEvenGrandparent(root.right);
        return res;
    }

    public int sumEvenGrandparent2(TreeNode root) {
        dfs(1,1,root); // 两轮不执行累加到root
        return res;
    }
    public void dfs(int gpVal,int pVal,TreeNode node){
        if (node==null){
            return;
        }
        if (gpVal%2==0){
            res+=node.val;
        }
        dfs(pVal,node.val,node.left);
        dfs(pVal,node.val,node.right);
    }

}
