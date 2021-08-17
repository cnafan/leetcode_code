package com.offer.offer68_1;

import com.leetcode.tree.TreeNode;

/**
 * @deprecated  `遍历，如果p和q 的值都大于或者都小于当前节点，那么公共父节点还在更深处；如果一个大一个小，那么当前节点就是分叉节点，即公共节点`
 *
 *
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // root==q 说明q是p的父节点
        if (root == null || root == q || root == p) {
            return root;
        }
        if (root.val>p.val&&root.val>q.val)
        return lowestCommonAncestor(root.left, p, q);

        if (root.val<p.val&&root.val<q.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}
