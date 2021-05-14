package com.leetcode.dp.interview1617;


public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length + 1];
        int[] mini1 = new int[nums.length + 1];
        mini1[0] = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            mini1[i] = min;
        }
        dp[0] = 0;
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] - mini1[i - 1]);
            if (max < dp[i]) {
                max = dp[i];
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{7, 1, 5, 3, 6, 4}));
    }
}



