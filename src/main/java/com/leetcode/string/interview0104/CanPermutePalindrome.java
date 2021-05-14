package com.leetcode.string.interview0104;

public class CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        // 所有字符用128 小写字母用26
        int[] hash=new int[128];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        int j=0;
        for (int k : hash) {
            if (k % 2 == 1) {
                j++;
            }
        }
        return j <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new CanPermutePalindrome().canPermutePalindrome("AaBb//a"));
    }
}
