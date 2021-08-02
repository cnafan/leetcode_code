package com.offer.offer32_3;

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
        bfs(root, res);
        return res;
    }

    void bfs(TreeNode root, List<List<Integer>> res) {
        boolean index = false;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> temp = new LinkedList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (res.size()%2==1) {
                    temp.addFirst(node.val);
                }else {
                    temp.addLast(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            index = !index;
            res.add(temp);
        }
    }
}
