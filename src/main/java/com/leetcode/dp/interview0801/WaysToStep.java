package com.leetcode.dp.interview0801;


/**
 * dp[i]=dp[i-1]+dp[i-2]+dp[i-3]
 *
 * dp[0]=1;
 * dp[1]=2;
 * dp[2]=4;
 */
public class WaysToStep {
    public int waysToStep(int n) {
        if (n<3){
            return n;
        }
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        dp[2]=4;
        for (int i = 3; i < n; i++) {
            dp[i]=((dp[i-1]+dp[i-2])%1000000007+dp[i-3])%1000000007;;
        }
        return (dp[n-1]);
    }

    public static void main(String[] args) {
        System.out.println(new WaysToStep().waysToStep(3));
    }

}

