package com.leetcode.string.console5;

import java.util.Arrays;

public class LongestPalindrome {

    /**
     * 中心扩散
     * 对于每一个元素，分别向两侧扩散先找到不一样的元素，然后同时对比
     * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-fa-he-dong-tai-gui-hua-by-reedfa/
     * @date : 2021-08-21 22:57
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        // 特例
        if (s.length() <2) {
            return s;
        }
        int max=1;
        int left=0,right=0;
        int maxStart=-1;// left所处位置的前一个
        for (int i = 0; i < s.length(); i++) {
            left=i-1;
            right=i+1;
            int len=1;
            while (left>=0&&s.charAt(left)==s.charAt(i)){
                left--;
                len++;
            }
            while (right<s.length()&&s.charAt(right)==s.charAt(i)){
                right++;
                len++;
            }
            while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                left--;
                right++;
                len+=2;
            }
            if (len>max){
                max=len;
                maxStart=left;
            }
        }
        return s.substring(maxStart+1,maxStart+max+1);

    }

    /**
     * dp[i][j]:表示i-j的串是否为回文
     * dp[i][j]=dp[i-1][j+1]&&(i-1)==(j+1)
     *
     * dp[
     * @date : 2021-08-21 22:57
     * @param s
     * @return
     */
    public String longestPalindrome4(String s) {

        // 特例
        int len = s.length();
        if (len <2) {
            return s;
        }
        int max=1;
        int maxStart=0;// left所处位置
        boolean[][] dp=new boolean[s.length()][s.length()];
        for (int right = 1; right < s.length(); right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left)==s.charAt(right)&&(right-left<=2||dp[left+1][right-1])){
                    dp[left][right]=true;
                    if (max<right-left+1){
                        max=right-left+1;
                        maxStart=left;
                    }
                }
            }
        }
        return s.substring(maxStart,maxStart+max);
    }

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
        System.out.println(new LongestPalindrome().longestPalindrome3("cbbd"));
    }
}
