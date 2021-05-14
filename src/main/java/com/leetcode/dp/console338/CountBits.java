package com.leetcode.dp.console338;

import java.util.Arrays;

public class CountBits {
    public int[] countBits(int num) {
        int[] dp=new int[num+1];
        dp[0]=0;
        if (num==0){
            return dp;
        }
        dp[1]=1;
        if (num==1){
            return dp;
        }
        dp[2]=1;
        for (int i = 0; i <= num / 2; i++) {
            dp[2*i]=dp[i];
            if (2*i+1<=num) { // n为偶数时，2n+1越界
                dp[2 * i + 1] = dp[i] + 1;
            }
        }
        return dp;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountBits().countBits(5)));
    }

}
/**
 * 于一个二进制数来说，如果它的最低位为1(%2 为 1）,则它与 n/2 的 1 个数相差1。
 * 如果它的最低位为 0，则它与 n/2 的 1 个数相同 这样就可以用前面的推出后面的
 */
