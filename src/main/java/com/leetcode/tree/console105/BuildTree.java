package com.leetcode.tree.console105;

import com.leetcode.tree.TreeNode;

public class BuildTree {
    /**
     * 递归
     *
     *
     * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return helper(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    /**
     * 左开右闭
     * @param preorder
     * @param p_start
     * @param p_end
     * @param inorder
     * @param i_start
     * @param i_end
     * @return
     */
    public TreeNode helper(int[] preorder,int p_start,int p_end,int[] inorder,int i_start,int i_end){
        if (p_start==p_end){
            return null;
        }

        int root_val=preorder[p_start];
        TreeNode root=new TreeNode(root_val);

        // 找到根节点在中序遍历中的位置
        int i_root_index=0;
        for (int i = i_start; i < i_end; i++) {
            if (root_val==inorder[i]){
                i_root_index=i;
                break;
            }
        }

        int leftNum=i_root_index-i_start;
        root.left=helper(preorder,p_start+1,p_start+leftNum+1,inorder,i_start,i_root_index);
        root.right=helper(preorder,p_start+leftNum+1,p_end,inorder,i_root_index+1,i_end);

        return root;

    }
}
