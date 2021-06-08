package com.leetcode.tree.console230;

import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Inorder {
    int index = 1, ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        kthSmallest(root.left, k);
        if (index++ == k) {
            ans = root.val;
        }
        kthSmallest(root.right, k);
        return ans;
    }


    public int kthSmallest2(TreeNode root, int k) {
        List<Integer> arr;
        arr = dfs(root, new ArrayList<>());
        return arr.get(k - 1);
    }

    public List<Integer> dfs(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return arr;
        }
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
        return arr;
    }

}
