package com.offer.offer47;

/**
 * dp[i][j]:到达第i,j格子所能拿到的最大价值礼物
 *
 * dp[i][j]=dp[i-1][j]+dp[i][j-1]+grid[i][j]
 *
 * dp[i][0]=dp[i-1][0]+grid[i][0]
 * dp[0][j]=dp[0][j-1]+grid[0][j]
 *
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        if (grid.length<1){
            return 0;
        }
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new MaxValue().maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
