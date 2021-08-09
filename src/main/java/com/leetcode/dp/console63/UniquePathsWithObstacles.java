package com.leetcode.dp.console63;

import java.util.Arrays;

/**
 * dp[i][j]:走到i,j)位置可能的路径
 * dp[i][j]=dp[i-1][j](num[i-1][j]!=1)+dp[i][j-1](num[i][j-1]!=1);
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 1) {
            return -1;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        // 一旦遇到障碍物就跳出循环了，
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) {
//        int[][] ints = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//        int[][] ints = {{0,0},{0, 1}};
        int[][] ints = {{0, 1, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(ints));
    }
}
