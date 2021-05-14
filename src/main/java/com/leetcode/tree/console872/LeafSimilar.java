package com.leetcode.tree.console872;

import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        find(list1,root1);
        find(list2,root2);
        return list1.equals(list2);
    }
    public void find(List<Integer> list,TreeNode root){
        if (root==null){
            return;
        }
        if (root.left==null&&root.right==null){
            list.add(root.val);
            return;
        }
        find(list,root.left);
        find(list,root.right);
    }
}
