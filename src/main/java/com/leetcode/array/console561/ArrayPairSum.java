package com.leetcode.array.console561;

import java.util.Arrays;

public class ArrayPairSum {
    public static void main(String[] args) {
        System.out.println(new ArrayPairSum().arrayPairSum(new int[]{1, 4, 3, 2}));
    }
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int add=0;
        for (int i = 0; i < nums.length; i+=2) {
            add+=nums[i];
        }
        return add;
    }
}
