package com.offer.offer61;

import java.util.Arrays;

public class IsStraight {
    // 有两个相同的的即不连续
    // 统计空缺的个数，以及0的个数，如果0的个数大于空缺个数即连续
    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length < 1) {
            return true;
        }
        Arrays.sort(nums);
        int fast = 0, slow = 0, zero_count = 0, lack = 0;
        while (nums[fast] == 0) {
            zero_count++;
            fast++;
        }
        slow = fast;
        fast++;
        while (fast < nums.length) {
            int rm = nums[fast] - nums[slow] - 1;
            if (rm == -1) {
                return false;
            }
            if (rm > 0) {
                lack += rm;
            }
            slow = fast;
            fast++;
        }
        return lack == 0 || lack <= zero_count;


    }

    public static void main(String[] args) {
        System.out.println(new IsStraight().isStraight(new int[]{4,7,5,9,2}));
    }
}
