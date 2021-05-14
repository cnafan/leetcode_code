package com.leetcode.string.console1446;

public class MaxPower {

    public int maxPower(String s) {
        int max=1;
        int current=1;
        char cur=s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)==cur){
                current++;
                if (current>max){
                    max=current;
                }
            }else {
                current=1;
                cur=s.charAt(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxPower().maxPower("tourist"));
    }
}
