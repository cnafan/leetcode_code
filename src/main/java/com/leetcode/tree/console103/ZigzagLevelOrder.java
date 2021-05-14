package com.leetcode.tree.console103;

import com.leetcode.tree.TreeNode;

import java.util.*;

/**
 * 锯齿形层序遍历是在层序遍历的基础上增加一个标志，按照每层不同的处理
 * 奇数层 顺序遍历
 * 偶数层 逆序
 *
 * 所以添加和遍历的顺序不变，只是添加的位置从尾端变为首端，因此需要使用 `Deque<Integer> list = new LinkedList<>();`
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        int i = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return ret;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            Deque<Integer> list = new LinkedList<>();
            int len = queue.size();
            for (int j = 0; j < len; j++) {
                TreeNode node;
                node = queue.poll();
                if (i % 2 == 1)
                    list.addFirst(node.val);
                else {
                    list.addLast(node.val);
                }
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);

            }
            i++;
            ret.add(new LinkedList<>(list));
        }
        return ret;
    }

}
