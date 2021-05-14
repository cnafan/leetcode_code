package com.leetcode.string.console1370;

import java.util.ArrayList;
import java.util.List;

public class SortString {
    public String sortString(String s) {
        StringBuilder res=new StringBuilder();
        int[] tong=new int[26];
        for (int i = 0; i < s.length(); i++) {
            tong[s.charAt(i)-'a']++;
        }

        //
        while (res.length()<s.length()){
            for (int i = 0; i < 26; i++) {
                if (tong[i]>0){
                    res.append((char)(i+'a'));
                    tong[i]--;
                }
            }

            for (int i = 25; i >=0 ; i--) {
                if (tong[i]>0){
                    res.append((char)(i+'a'));
                    tong[i]--;
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SortString().sortString("aaaabbbbcccc"));
    }
}
