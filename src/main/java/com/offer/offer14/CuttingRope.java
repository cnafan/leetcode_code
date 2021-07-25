package com.offer.offer14;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * dp[i]:表示长度为i的绳子剪掉m段的最大乘积
 * <p>
 * dp[2]=1 长度为2的绳子，剪成两端，乘积为1
 * <p>
 * 绳子先减第一段长度为j，接下来有两种情况，第一种不减，乘积为j*(i-j)，第二种情况为继续减：乘积为j*dp[i-j]
 * 而第一段绳子
 * dp[i]=max{j*(i-j),j*dp[i-j]}
 */
public class CuttingRope {

    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i < n+1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] =Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];

    }

    public int cuttingRope2(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        // dp[1] = BigInteger.valueOf(1);
        for(int i = 3; i < n + 1; i++){
            for(int j = 1; j < i; j++){
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();

//        链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/di-zi-fen-xi-shi-yong-dong-tai-gui-hua-q-jlr7/

    }
    public static void main(String[] args) {
        System.out.println(new CuttingRope().cuttingRope(10));
    }
}
