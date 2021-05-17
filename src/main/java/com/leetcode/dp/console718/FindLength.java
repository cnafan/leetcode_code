package com.leetcode.dp.console718;

public class FindLength {
    /**
     * dp[i][j]:第i个元素和第j个元素的最长连续子序列
     *
     * dp[i][j]=dp[i-1][j-1]+1 : num1[i]==num2[j]
     * dp[i][j]=0 : num1[i]!=num2[j]
     *
     * dp[0][0]=0
     *
     * 时间复杂度：O(mn)
     *
     *  https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-dong-tai-gu-91zl/
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        int result=0;

        dp[0][0] = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j]=0;
                }
                result=Math.max(dp[i][j],result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindLength().findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }
}
