package com.leetcode.array.console283;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {

        int[] nums = {5, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 双指针
     * j指向为0的元素
     * 当i指向不为0 的元素时，交换i j
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

    }
}
