package com.leetcode.bfs.console103;

import com.leetcode.tree.TreeNode;

import java.util.*;

/**
 * 使用bfs，每次处理一层，观察可得正常遍历，存放的时候分奇偶存放
 *
 * @author : cnafan
 * @date : 2021-08-26 20:13
 **/
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean is=true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> list=new LinkedList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (is){
                    list.addFirst(node.val);
                }else {
                    list.addLast(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            is=!is;
            res.add(new LinkedList<>(list));
        }
        return res;

    }
}
