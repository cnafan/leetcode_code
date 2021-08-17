package com.offer.offer68_2;

import com.leetcode.tree.TreeNode;

/**
 *
 *
 *
 * 找公共父节点可以转换为递归找两个子节点
 * 对于每个节点先序递归查找两个子节点，若当前节点是，则当前节点就是公共节点，若当前节点不是，则递归找左右子树，如果左右都找到了，则说明两个节点分布在左右两侧；若左边没找到说明都在右边。同理即可。
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // root==q 说明q是p的父节点
        if (root == null || root == q || root == p) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
