package com.leetcode.dp.console70;

/**
 * @apiNote  startTime:2020/0303/14:52 endTime:15:02
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n==1){
            return 1;
        }
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        for (int i = 2; i < n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(4));
    }
}
/**
 * dp[i]
 *
 * dp[i]=dp[i-1]+dp[i-2]
 *
 * dp[1]=1
 * dp[2]=2
 *
 *
 */
