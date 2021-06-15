package com.leetcode.tree.console114;

import com.leetcode.tree.TreeNode;

public class Flatten {
    /**
     * 把左子树放到右子树位置，把右子树放到新右子树的右子树
     * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
     * @param root
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left!= null) {
                // 找到左子树的最右子树
                TreeNode leftright=root.left;
                while (leftright.right != null) {
                    leftright=leftright.right;
                }

                // 把右子树接到上面找到的节点
                leftright.right=root.right;
                root.right=root.left;
                root.left=null;
            }

            root=root.right;

        }

    }
}
