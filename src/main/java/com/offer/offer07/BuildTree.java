package com.offer.offer07;

import com.leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * 优化方向：使用O(n)的空间存储哈希,以便后续定位O(1)的时间
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 终止条件
        if (preorder.length == 0) {
            return null;
        }

        int rootValue = preorder[0];
        // 找到根节点的位置
        int rootIndex = 0;
        for (int i = 0; i < preorder.length; i++) {
            if (rootValue == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length), Arrays.copyOfRange(inorder, rootIndex + 1, preorder.length));
        return root;
    }
}
