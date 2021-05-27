package com.leetcode.tree.offer54;

import com.leetcode.tree.TreeNode;

/**
 * dfs
 */
public class KthLargest {
    int res = -1, kk;
    public int kthLargest(TreeNode root, int k) {
        kk = k;
        dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        // 终止条件
        if (root == null) {
            return;
        }
        dfs(root.right);
        kk--;
        if (kk == 0) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }

//    public int kthLargest(TreeNode root, int k) {
//        Queue<TreeNode> queue=new LinkedList<>();
//        queue.offer(root);
//        int index=1;
//        while (!queue.isEmpty()){
//            TreeNode node = queue.poll();
//            if (index == k) {
//                return node.val;
//            }
//            if (node.left!=null){
//                queue.offer(node.left);
//            }
//            if (node.right!=null){
//                queue.offer(node.right);
//            }
//        }
//        return -1;
//    }
}
