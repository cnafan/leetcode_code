package com.leetcode.tree.console173;

import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTIterator {

    private int index;
    private List<Integer> res;
//    public BSTIterator(TreeNode root) {
//        index=0;
//        res=new ArrayList<>();
//        dfs(root,res);
//    }
//
//    public void dfs(TreeNode tree,List<Integer> list){
//        if (tree==null ){
//            return;
//        }
//        dfs(tree.left,list);
//        list.add(tree.val);
//        dfs(tree.right,list);
//    }
//
//    public int next() {
//       return res.get(index++);
//    }
//
//    public boolean hasNext() {
//        return index<res.size();
//    }


    private Stack<TreeNode> stack;
    private TreeNode cur;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        cur = root;
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return cur!=null||!stack.isEmpty();
    }
}
