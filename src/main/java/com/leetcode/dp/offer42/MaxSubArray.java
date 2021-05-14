package com.leetcode.dp.offer42;

/**
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        int[] dp=new int[nums.length];

        dp[0]=nums[0];
        int max=nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            if (dp[i]>max){
                max=dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}

/**
 * dp[i] :前i个数组的最大和
 *
 * dp[0]=4
 * dp[1]=max{dp[0]+n[1],n[1]}
 *
 * dp[i]=max{dp[i-1]+n[i],n[i]}
 */
