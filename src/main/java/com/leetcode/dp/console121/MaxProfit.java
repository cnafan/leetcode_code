package com.leetcode.dp.console121;

/**
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 */
public class MaxProfit {
    /**
     * 分析规律：在数组为：[7,1,5,3,6,4]时，第一天的收益必然为0，第二天的收益也为0，第三天的最大收益为4.
     * 也就是第二天的股票收益应该在前一天股票最大收益与当天股票值和到前一天为止的股票最小值之差之间取出最大。
     *
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        if (prices.length<1){
            return 0;
        }
        int[] dp=new int[prices.length];
        int min=prices[0];
        dp[0]=0;
        for (int i = 1; i < prices.length; i++) {
            dp[i]=Math.max(dp[i-1],prices[i]-min);
            if (prices[i]<min){
                min=prices[i];
            }
        }
        return dp[prices.length-1];
    }
    public int maxProfit2(int[] prices) {

        int[] dp = new int[prices.length + 1];
        int[] mini1 = new int[prices.length + 1];
        mini1[0] = prices[0];
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            mini1[i] = min;
        }
        dp[0] = 0;
        int max = dp[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - mini1[i - 1]);
            if (max < dp[i]) {
                max = dp[i];
            }

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new MaxProfit().maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }
}

/**
 * 利润 dp[i][j]: 第i天买入 ，第j天卖出的利润
 * dp[i-1][j]: 第i-1天买入，第j天卖出的利润
 * <p>
 * dp[i][j]=max{dp[i-1][j]+(num[i]-num[i-1]),dp[i][j-1]+(num[j]-num[j-1])}
 * <p>
 * dp[0][0]=0
 * dp[1][j]=num[j]-num[0]
 * <p>
 * <p>
 * dp[i]: 前i天的最大收益
 * <p>
 * dp[i]=max{dp[i-1],(num[i]-min{num[i-1]}}
 * <p>
 * dp[0]=0
 * dp[1]=num[2]-num[1]
 * <p>
 * dp[i]: 前i天的最大收益
 * <p>
 * dp[i]=max{dp[i-1],(num[i]-min{num[i-1]}}
 * <p>
 * dp[0]=0
 * dp[1]=num[2]-num[1]
 */


/**
 * dp[i]: 前i天的最大收益
 *
 * dp[i]=max{dp[i-1],(num[i]-min{num[i-1]}}
 *
 * dp[0]=0
 * dp[1]=num[2]-num[1]
 *
 *
 */
