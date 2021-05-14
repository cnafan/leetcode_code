package com.leetcode.string.console1221;

public class BalancedStringSplit {
    public int balancedStringSplit(String s) {
        int res = 0;
        char F = s.charAt(0);
        int first = 1;
        for (int i = 1; i < s.length(); i++) {
            if (F != s.charAt(i)) {
                first--;
            } else {
                first++;
            }
            if (first == 0) {
                res++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(new BalancedStringSplit().balancedStringSplit("LLLLRRRR"));
    }
}
