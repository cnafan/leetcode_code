package com.leetcode.tree.console94;

import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 */
public class InorderTraversal {

    /**
     * 递归版本
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(ret, root);
        return ret;
    }

    public void dfs(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(list, root.left);
        list.add(root.val);
        dfs(list, root.right);
    }

    /**
     * 迭代版本：
     * <p>
     * 时间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return ret;
        }
        while (!stack.isEmpty() || root != null) {
            // 一直往左子树走
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {// stack不为空，root为空
                TreeNode node = stack.pop();
                ret.add(node.val);
                root = node.right;
            }
        }
        return ret;
    }
}
