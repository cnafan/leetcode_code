package com.leetcode.dp.console62;

/**
 * dp[i][j]：到达第[i][j]个位置的路径数
 *
 * dp[i][j]=dp[i-1][j]+dp[i][j-1]
 *
 * dp[0,0]=0
 * dp[1,0]=1
 * dp[0,1]=1
 *
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n ];
        dp[0][0]=0;
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(1, 2));
    }
}
