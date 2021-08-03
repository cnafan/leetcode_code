package com.offer.offer46;

/**
 * dp[i]=表示前i个字符的翻译数
 * x
 * <p>
 * dp[i]=dp[i-1]+dp[i-2] 翻译两个
 * dp[i]=dp[i-1] 翻译一个
 * <p>
 * dp[0]=1
 * dp[1]=1
 */
public class TranslateNum {
    public int translateNum(int num) {
        String str_num = String.valueOf(num);
        int[] dp = new int[str_num.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < str_num.length() + 1; i++) {
            if (str_num.substring(i - 2, i).compareTo("10") >= 0 && str_num.substring(i - 2, i).compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[str_num.length()];
    }

    public static void main(String[] args) {
        System.out.println(new TranslateNum().translateNum(12258));
    }
}
