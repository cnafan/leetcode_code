package com.leetcode.backtrack.console113;

import com.leetcode.tree.TreeNode;
import javafx.scene.effect.Effect;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的回溯要判断左右节点分别回溯
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        backtrace(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    void backtrace(TreeNode root, int targetSum, List<Integer> temp, List<List<Integer>> res) {
        temp.add(root.val);
        targetSum -= root.val;
        if (root.left==null&&root.right==null) { // 叶子节点 判断
            if (0 == targetSum) {
                res.add(new ArrayList<>(temp));
                return;
            }
        }

        if (root.left != null) {
            backtrace(root.left, targetSum, temp, res);
            temp.remove(temp.size() - 1);
        }
        if (root.right != null) {
            backtrace(root.right, targetSum, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
