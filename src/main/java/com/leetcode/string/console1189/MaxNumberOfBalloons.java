package com.leetcode.string.console1189;

public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] hash=new int[27];
        for (int i = 0; i < text.length(); i++) {
            hash[text.charAt(i)-'a']++;
        }
        int ab=Math.min(hash[0],hash[1]);
        int lo=Math.min(hash['l'-'a'],hash['o'-'a'])/2;
        return Math.min(Math.min(ab,lo),hash['n'-'a']);
    }

    public static void main(String[] args) {
        System.out.println(new MaxNumberOfBalloons().maxNumberOfBalloons("nlaebolko"));
    }

}
