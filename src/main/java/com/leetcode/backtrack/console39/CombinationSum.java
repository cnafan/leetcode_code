package com.leetcode.backtrack.console39;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrace(candidates, target, res, tmp, 0, candidates.length);
        System.out.println(res);
        return res;
    }

    void backtrace(int[] candidates, int target, List<List<Integer>> res, List<Integer> tmp, int begin, int len) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = begin; i < len; i++) {
            tmp.add(candidates[i]);
            backtrace(candidates, target - candidates[i], res, tmp, i, len);
            tmp.remove(tmp.size() - 1);
        }

    }

    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
