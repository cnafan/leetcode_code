package com.leetcode.dp.console198;

/**
 * dp[i]:第i天收益
 *
 * dp[i]=max{dp[i-2]+num[i],dp[i-1]}
 *
 * dp[0]=num[0]
 * dp[1]=max{dp[0],num[1]}
 *
 */
public class Rob {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n==1){
            return nums[0];
        }
        int[] dp=new int[n];

        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Rob().rob(new int[]{2,7,9,3,1}));
    }
}
