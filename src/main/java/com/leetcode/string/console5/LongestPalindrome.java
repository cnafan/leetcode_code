package com.leetcode.string.console5;

import java.util.Arrays;

public class LongestPalindrome {

    /**
     * dp[i][j]:第i个字符到第j个字符之间的字符串是否为回文字符串
     *
     * （官方视频题解）https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
     * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/qu-jian-dpjian-dan-yi-dong-de-er-wei-tu-cvmnw/
     *
     * 时间复杂度：o(n^2)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        // 特例
        int len = s.length();
        if (len <2) {
            return s;
        }
        // 记录两个值，不需截取字符串
        int maxLen = 1;
        int begin=0;

        int[][] dp = new int[len][len];
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        // 按列计算 ，
        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {

                if (s.charAt(i) != s.charAt(j)){
                    dp[i][j]=0;
                }else {
                    if (j-i<3){ // 当长度小于等于3时，只需判断首尾是否相等
                        dp[i][j]=1;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if (dp[i][j]==1&&j-i+1>maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    /**
     * 中心扩展
     * <p>
     * 时间复杂度：O(n^2)
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            ans = helper(i, i, s, ans);
            ans = helper(i, i + 1, s, ans);
        }
        return ans;
    }

    public String helper(int m, int n, String s, String ans) {
        while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
            m--;
            n++;
        }
        // 注意此处m,n的值循环完后  是恰好不满足循环条件的时刻
        // 此时m到n的距离为n-m+1，但是mn两个边界不能取 所以应该取m+1到n-1的区间  长度是n-m-1
        if (n - m - 1 > ans.length()) {
            //substring要取[m+1,n-1]这个区间
            //end处的值不取,所以下面写的是n不是n-1
            ans = s.substring(m + 1, n);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abababaa"));
    }
}
