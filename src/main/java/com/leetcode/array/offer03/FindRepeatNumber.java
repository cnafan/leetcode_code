package com.leetcode.array.offer03;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
    public static void main(String[] args) {
        System.out.println(new FindRepeatNumber().findRepeatNumber3(new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
    }

    // 时间复杂度 O(n)
    public int findRepeatNumber(int[] nums) {
        boolean[] hash = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (hash[nums[i]]) {
                return nums[i];
            } else {
                hash[nums[i]] = true;
            }
        }
        return nums[nums.length - 1];
    }

    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    // 原地排序 无需额外空间
    public int findRepeatNumber3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
