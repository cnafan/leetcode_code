package com.offer.offer60;

import java.util.Arrays;

/**
     * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/dong-tai-gui-hua-zhu-shi-qing-xi-by-zn5201314/
 *
 * dp[n][j]:n个骰子点数和为j的次数
 *
 *
 * dp[n][j]+=dp[n-1][j-i] i={1,2,3,4,5,6}
 *
 * dp[1][i]=1 i={1,2,3,4,5,6}
 */
public class DicesProbability {
    public double[] dicesProbability(int n) {
        int[][] dp=new int[n+1][6*n+1];

        for (int i = 1; i <= 6; i++) {
            dp[1][i]=1;//表示一个骰子掷出i点的次数为1
        }

        // i:骰子个数
        for (int i = 2; i <= n; i++) {
            // j:点数出现的次数,当前最大值 = 6 * 骰子个数 //表示可能会出现的点数之和
            for (int j = i; j <= 6*i; j++) {
//表示当前这个骰子可能掷出的点数
                for (int k = 1; k <= 6; k++) {
                    if (j-k<i-1){
                        //当总数还没有j大时，就不存在这种情况
                        break;
                    }

                    //当前n个骰子出现的点数之和等于前一次出现的点数之和加上这一次出现的点数
                    dp[i][j]+=dp[i-1][j-k];
                }
            }
        }
        double total = Math.pow((double)6,(double)n);//掷出n次点数出现的所有情况
        double[] ans = new double[5*n+1];//因为最大就只会出现5*n+1中点数
        for(int i=n;i<=6*n;i++){
            ans[i-n]=((double)dp[n][i])/total;//第i小的点数出现的概率
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DicesProbability().dicesProbability(1)));
    }
}
