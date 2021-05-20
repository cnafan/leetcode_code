package com.leetcode.backtrack.console90;

import java.util.*;

/**
 * 同78题，多了重复元素
 */
public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 去重 要先排序
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        backtrace(nums, res, new ArrayList<>(),0);
        return new ArrayList<>(res);
    }

    void backtrace(int[] nums, Set<List<Integer>> res, List<Integer> temp,int begin) {
        res.add(new ArrayList<>(temp));
        for (int i = begin; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrace(nums, res, temp,i+1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{4,4,4,1,4}));
    }
}
