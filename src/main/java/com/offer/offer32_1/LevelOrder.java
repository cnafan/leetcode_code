package com.offer.offer32_1;

import com.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    Queue<TreeNode> queue;

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        bfs(root, res);
        return res.stream().mapToInt(Integer::intValue).toArray();

    }

    void bfs(TreeNode root, List<Integer> list) {
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
//            System.out.println(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
    }
}
