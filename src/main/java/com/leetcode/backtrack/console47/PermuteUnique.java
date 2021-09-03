package com.leetcode.backtrack.console47;

import java.util.*;

/**
 * 同46，回溯，只增加了去重
 * 两种去重：
 *  set去重
 *  list，排序后，跳过重复值
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        // set去重
        Set<List<Integer>> res = new HashSet<>();
        backtrack(nums, new ArrayList<>(), res, visited);
        // 排序去重
        List<List<Integer>> res2 = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), res2, visited);

        return new ArrayList<>(res2);
    }

    void backtrack(int[] nums, List<Integer> temp, Set<List<Integer>> res, int[] visit) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 1 ) {
                continue;
            }
            temp.add(nums[i]);
            visit[i] = 1;
            backtrack(nums, temp, res, visit);
            visit[i] = 0;
            temp.remove(temp.size() - 1);
        }

    }
    void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> res, int[] visit) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 1 || (i>0&&visit[i - 1] == 0 && nums[i] == nums[i - 1])) {
                continue;
            }
            temp.add(nums[i]);
            visit[i] = 1;
            backtrack(nums, temp, res, visit);
            visit[i] = 0;
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{1,2, 1, 2}));
    }
}
