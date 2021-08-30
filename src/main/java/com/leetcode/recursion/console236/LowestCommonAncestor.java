package com.leetcode.recursion.console236;

import com.leetcode.link.ListNode;
import com.leetcode.tree.TreeNode;

/**
 * 对于每个节点查找p和q
 * 如果当前节点为q，则q是两者的公共节点；若为p，则p是公共节点
 * 如果p在左子树，且q在右子树，说明当前节点为公共节点
 *
 * @author : cnafan
 * @date : 2021-08-27 12:33
 **/
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归终止
        if (root == p||root == q||root==null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}
