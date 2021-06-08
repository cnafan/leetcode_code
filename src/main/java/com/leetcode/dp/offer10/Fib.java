package com.leetcode.dp.offer10;

/**
 * dp[i]=dp[i-1]+dp[i-2];
 */
public class Fib {

    // 只用到了前两个，优化只保存前两个
    public int fib2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long[] dp = new long[2];
        dp[0] = 1;
        dp[1] = 1;
        long num = 1000000007;
        for (int i = 2; i < n + 1; i++) {
            long temp = dp[1];
            dp[1] = (dp[0] + dp[1]) % num;
            dp[0] = temp;
        }
        return (int) dp[1];
    }

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long num = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i]%=num;
        }
        return (int) (dp[n] % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new Fib().fib(2));
    }
}
