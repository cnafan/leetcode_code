package com.leetcode.backtrack.console47;

import java.util.*;

/**
 * 同46，回溯，只增加了去重
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
         backtrack(nums, new ArrayList<>(),res, visited);
         return new ArrayList<>(res);
    }

    void backtrack(int[] nums, List<Integer> temp,Set<List<Integer>> res, int[] visit) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 1) {
                continue;
            }
            temp.add(nums[i]);
            visit[i] = 1;
            backtrack(nums, temp,res, visit);
            visit[i] = 0;
            temp.remove(temp.size()-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{1,1,2}));
    }
}
