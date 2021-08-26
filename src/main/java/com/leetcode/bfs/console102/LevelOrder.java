package com.leetcode.bfs.console102;

import com.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 使用bfs 每次处理一层的即可
 * @author : cnafan
 * @date : 2021-08-26 19:48
 **/
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp=new ArrayList<>();
            int size = queue.size();
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
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
