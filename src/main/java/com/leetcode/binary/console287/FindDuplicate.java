package com.leetcode.binary.console287;

import java.util.Arrays;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            int slow = nums[i];
            int fast = nums[i + 1];
            if (slow == fast) {
                return slow;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicate().findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }
}
