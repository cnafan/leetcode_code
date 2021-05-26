package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildTree(Object[] nums) {
        if (nums.length < 1) {
            return new TreeNode(-1);
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        int index = 0;
        TreeNode root;
        root = new TreeNode((int) nums[index++]);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (index < nums.length) {
                TreeNode left;
                if (null == nums[index]) {
                    left = new TreeNode(999);
                } else {
                    left = new TreeNode((int) nums[index]);
                }
                queue.offer(left);
                poll.left = left;
                index++;
            }
            if (index < nums.length) {
                TreeNode right;
                if (null == nums[index]) {
                    right = new TreeNode(999);
                } else {
                    right = new TreeNode((int) nums[index]);
                }
                queue.offer(right);
                poll.right = right;
                index++;
            }
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    System.out.print("null ");
                } else {
                    System.out.print(node.val + " ");
                }
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                if (i == len - 1) {
                    System.out.println("");
                }
            }
        }
    }
}
