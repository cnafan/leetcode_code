package com.leetcode.backtrack.console322;

import java.util.Arrays;

public class CoinChange {
    /**
     * dp[i]:组成i所需最小硬币数
     * dp[i]=min{dp[i-coin]+1,dp[i]}
     * <p>
     * dp[0]=0
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    /**
     * 记忆化搜索
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {

        // 记忆
        int[] memo = new int[amount + 1];
        return dfs(coins, amount, memo);
    }

    int dfs(int[] coins, int amount, int[] memo) {
        // 终止条件
        if (amount == 0) {
            return 0;
        }
        if (amount == -1) {
            return -1;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }

        // 求解
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 剪枝
            if (amount < coin) {
                continue;
            }
            int ret = dfs(coins, amount - coin, memo);
            if (ret == -1) {
                continue;
            }
            result = Math.min(result, ret + 1);//// 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
        }
        if (result == Integer.MAX_VALUE) {
            result = -1;
        }

        // 更新
        memo[amount] = result;

        // 回溯
        return memo[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new CoinChange().coinChange2(new int[]{1, 2, 5}, 11));
    }
}
