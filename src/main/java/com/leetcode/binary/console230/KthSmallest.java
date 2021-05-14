package com.leetcode.binary.console230;

import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallest {

    //栈迭代
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
//        List<Integer> arr=new ArrayList<>();
        int res = 0;
        TreeNode cur = root;
        int index = 0;
        while (index != k) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res = (cur.val);
            index++;
            cur = cur.right;
        }
        return res;
    }


//    // 递归
//    public void dfs(TreeNode root, List<Integer> arr) {
//        if (root==null)
//            return;
//        dfs(root.left, arr);
//        arr.add(root.val);
//        dfs(root.right, arr);
//    }
//
//    public int kthSmallest(TreeNode root, int k) {
//        TreeNode cur = root;
//        List<Integer> arr=new ArrayList<>();
//        dfs(root,arr);
//        return arr.get(k-1);
//    }
}
