package com.leetcode.dp.console122;

/**
 * dp[i][j]:第i天持有股票的最大收益或者不持有股票的最大收益
 * dp[i][0]=max{dp[i-1][0],dp[i-1][1]-price[i]} 不持有股票，前一天也不持有，或者前一天持有，当天卖出
 * dp[i][1]=max{dp[i-1][1],dp[i-1][0]-price[i]} 持有股票
 * dp[0][0]=0;
 * dp[0][1]=-price[0]
 * 由于全部交易结束后，持有股票的收益一定低于不持有股票的收益，因此这时候 \textit{dp}[n-1][0]dp[n−1][0] 的收益必然是大于 \textit{dp}[n-1][1]dp[n−1][1] 的，最后的答案即为 \textit{dp}[n-1][0]dp[n−1][0]。
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 当天卖出可以获得收益price[i]
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 当天买入需要减少收益price[i]
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
