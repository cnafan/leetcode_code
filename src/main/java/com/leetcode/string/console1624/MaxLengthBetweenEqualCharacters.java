package com.leetcode.string.console1624;

import java.util.Arrays;

public class MaxLengthBetweenEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res=-1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length()-1; j >i ; j--) {
                if (s.charAt(i)==s.charAt(j)){
                    res=Math.max(res,j-i-1);
                }
            }
        }
        return res;
    }
    public int maxLengthBetweenEqualCharacters2(String s) {
        int res=-1;
        int[] hash=new int[27];
        Arrays.fill(hash,-1);
        for (int i = 0; i < s.length(); i++) {
            int index=s.charAt(i)-'a';
            if (hash[index]==-1){
                hash[index]=i;
            }else {
                res=Math.max(res,i-hash[index]-1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxLengthBetweenEqualCharacters().maxLengthBetweenEqualCharacters("aa"));
    }
}
