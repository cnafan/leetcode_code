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

        // 对于每一个元素，如果它大于它前面的某一个元素a，那就说明可以在以a为结尾的序列后面延长1，即dp[i]=dp[j]+1;
        // 若它是前面多个元素的延长点，那对于当前元素，应该选择它之前的元素中最大的那个子序列+1作为它的最长子序列，因此使用max函数统计最大值，然后更新
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
