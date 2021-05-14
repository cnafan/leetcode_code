package com.leetcode.tree.console1379;

import com.leetcode.tree.TreeNode;

import java.util.Stack;

public class GetTargetCopy {
    // 递归
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        // 递归终止条件,即根节点
        if (original == target) {
            return cloned;
        }

        // 左子树
        TreeNode res = getTargetCopy(original.left, cloned.left, target);
        if (res != null) {
            return res;
        }

        // 右子树
        res = getTargetCopy(original.right, cloned.right, target);
        if (res != null) {
            return res;
        }
        return null;
    }

    // 栈
    public final TreeNode getTargetCopy2(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(original);
        stack2.push(cloned);
        TreeNode node1=original;
        TreeNode node2=cloned;
        while (!stack1.isEmpty()) {
            node1 = stack1.pop();
            node2 = stack2.pop();
            if (node1 == target) {
                return node2;
            }
            // 先序遍历时先遍历左子树，所以入栈时先入右子树
            if (node1.right != null) {
                stack1.push(node1.right);
                stack2.push(node2.right);
            }
            if (node1.left != null) {
                stack1.push(node1.left);
                stack2.push(node2.left);
            }
        }
        return node2;
    }

}
