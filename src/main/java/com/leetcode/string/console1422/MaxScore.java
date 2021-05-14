package com.leetcode.string.console1422;


public class MaxScore {
    public int maxScore(String s) {
        int right=0,left=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='1'){
                right++;
            }
        }

        int maxscore=0;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i)=='1'){
                right--;
            }else {
                left++;
            }
            if (maxscore<left+right){
                maxscore=left+right;
            }
        }
        return maxscore;
    }

    public static void main(String[] args) {
        System.out.println(new MaxScore().maxScore("011101"));
    }
}
