package com.leetcode.tree.console199;

import com.leetcode.tree.TreeNode;

import java.util.*;

/**
 * dfs & bfs
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        dfs(res,root,0);
        return res;
    }

    void dfs(List<Integer> list, TreeNode root,int depth) {
        if (root == null) {
            return;
        }
        if (depth==list.size()) {
            list.add(root.val);
        }
        dfs(list, root.right,depth+1);
        dfs(list, root.left,depth+1);
    }

    /**
     * bfs
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == n - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }
}
