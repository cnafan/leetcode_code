package com.leetcode.dp.console221;

/**
 * dp[i][j]:以ij为右下角的正方形的最大面积
 *
 * 当前最大正方形的边长取决于三者的最小值+1，如图 https://leetcode-cn.com/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/
 * dp[i][j]=min{dp[i-1][j],dp[i][j-1],dp[i-1][j-1]}+1
 * @author : cnafan
 * @date : 2021-08-22 13:25
 **/
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix==null||matrix.length<1 ){
            return 0;
        }
        int max=0;
        int m=matrix.length,n=matrix[0].length;
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==1){
                    if (i==0||j==0){
                        dp[i][j]=1;
                    }else {
                        dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
