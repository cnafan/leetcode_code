package com.leetcode.dp.console1143;

public class LongestCommonSubsequence {
    /**
     * 最长公共子序列
     * 不连续
     *
     *
     *
     * dp[i][j]: text1[0][i] 、text2[0][j] 的最长子序列（左闭右开）
     * <p>
     * dp[i][j]=dp[i-1][j-1]+1 text1[i]==text2[j]
     * dp[i][j]=max{dp[i-1][j],dp[i][j-1]}
     * <p>
     * dp[0][0]=0
     * dp[1][0]=0
     * dp[0][1]=0
     *
     * https://leetcode-cn.com/problems/longest-common-subsequence/solution/fu-xue-ming-zhu-er-wei-dong-tai-gui-hua-r5ez6/
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        dp[0][0]=0;
        dp[0][1]=0;
        dp[1][0]=0;

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];

    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("asds", "acbs"));
    }
}
