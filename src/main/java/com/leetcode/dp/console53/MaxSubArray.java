package com.leetcode.dp.console53;

/**
 * dp[i]，以i为结尾的最大和
 * dp[i]=max{dp[i-1]+nums[i],nums[i]}
 * dp[0]=nums[0]
 *
 * 时间复杂度：O(n)
 *
 */

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            if (max<dp[i]){
                max=dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{1}));
    }
}
