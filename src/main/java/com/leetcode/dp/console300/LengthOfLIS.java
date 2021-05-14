package com.leetcode.dp.console300;

import java.util.Arrays;

public class LengthOfLIS {
    /**
     * 最长上升子序列
     *
     * dp[i]:以i结尾的子序列的长度
     *
     * dp[i]=max{dp[i],dp[j]+1}
     *
     * //初始化
     * dp[i]=1
     *
     * 时间复杂度：O(n^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int len=nums.length;
        if (len<2){
            return len;
        }
        int[] dp=new int[len];
        Arrays.fill(dp,1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int res=0;
        for (int i = 0; i < len; i++) {
            res=Math.max(dp[i],res);
        }
        return res;

    }
}
