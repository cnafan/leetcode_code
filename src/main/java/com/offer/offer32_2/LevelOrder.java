package com.offer.offer32_2;

import com.leetcode.tree.TreeNode;

import java.util.*;

public class LevelOrder {
    Queue<TreeNode> queue;

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue = new ArrayDeque<>();
        bfs(root,res);
        return res;
    }

    void bfs(TreeNode root, List<List<Integer>> res) {
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();

            while (size-- > 0) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(temp);
        }
    }
}
