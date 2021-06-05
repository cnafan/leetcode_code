package com.leetcode.backtrack.console518;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Change {

    /**
     * dp[i][j]:从i种重量互不相同的物品种选中若干物品，装满大小为j的背包的装法
     * dp[i][j]=dp[i-1][j](从少一种里面选)+dp[i][j-coin[i]](从多一种里面选，但是容量-选中物品的重量）
     * https://leetcode-cn.com/problems/coin-change-2/solution/dong-tai-gui-hua-jie-ti-li-qing-luo-ji-q-lddb/
     */
    public int change(int amount, int[] coins) {
        if (amount==0){
            return 1;
        }
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j-coins[i]<0){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]];
                }
            }
        }
        return dp[n][amount];
    }

    /**
     * 完全背包
     * dp[i]=dp[i-coin]
     * 状态压缩
     */
    public int change3(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        for (int coin :coins){
            for (int i = 1; i < amount+1; i++) {
                if (coin>i){
                    continue;
                }
                dp[i]+=dp[i-coin];
            }
        }
        return dp[amount];
    }


    /**
     * 回溯会超时
     */
    int res = 0;

    public int change2(int amount, int[] coins) {
        backtrace(amount, coins, 0);
        return res;
    }

    void backtrace(int amount, int[] coins, int start) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res++;
            return;
        }
        for (int i = start; i < coins.length; i++) {
            backtrace(amount - coins[i], coins, i);
        }
    }

    void backtrace2(int amount, int[] coins, List<Integer> temp, List<List<Integer>> res, int start) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < coins.length; i++) {
            temp.add(coins[i]);
            backtrace2(amount - coins[i], coins, temp, res, i);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Change().change(500, new int[]{3,5,7,8,9,10,11}));
        System.out.println(new Change().change2(500, new int[]{3,5,7,8,9,10,11}));
    }
}
