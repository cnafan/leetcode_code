package com.offer.offer34;

import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        backtrace(root, target, res, new ArrayList<>());
        return res;
    }

    void backtrace(TreeNode root, int target, List<List<Integer>> res, List<Integer> temp) {
        temp.add(root.val);
        if (root.left==null||root.right==null) {
            if (target==root.val) {
                res.add(new ArrayList<>(temp));
                return;
            }
        }
        if (root.left != null) {
            backtrace(root.left, target - root.val, res, temp);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            backtrace(root.right, target - root.val, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
