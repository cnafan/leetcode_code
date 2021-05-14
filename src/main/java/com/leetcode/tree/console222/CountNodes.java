package com.leetcode.tree.console222;

import com.leetcode.tree.TreeNode;

import java.util.logging.Level;

public class CountNodes {
    public int countNodes(TreeNode root) {
        TreeNode cur = root;
        // 获取深度
        int depth = 0;
        while (cur != null) {
            depth++;
            cur = cur.left;
        }

        // low&high
        int low=1<< depth;
        int high=(1<<(depth+1))-1;

        // 二分
        while (low<high){
            int mid=low+(high-low+1)/2;
            if (exist(root,depth,mid)){
                low=mid;
            }else {
                high=mid+1;
            }
        }
        return low;
    }

    // 判断是否存在(类似于霍夫曼树，左为0，右为1)
    public boolean exist(TreeNode root,int depth,int k){
        TreeNode cur=root;
        int bit=1<<(depth-1);
        while (cur!=null&&bit>0){
            if ((k&bit)==0){
                cur=cur.left;
            }else {
                cur=cur.right;
            }
            bit>>=1;
        }
        return cur!=null;

    }


}
