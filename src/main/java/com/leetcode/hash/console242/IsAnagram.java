package com.leetcode.hash.console242;

import java.util.Arrays;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] ss=s.toCharArray();
        char[] tt=t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);

        System.out.println(Arrays.toString(ss));
        System.out.println(Arrays.toString(tt));
        for (int i = 0; i < s.length(); i++) {
            if (ss[i]!=tt[i]){
                return false;
            }
        }
        return true;

    }
    public boolean isAnagram2(String s, String t) {
        int[] hash=new int[26];
        for (char c:s.toCharArray()){
            hash[c-'a']++;
        }
        for (char c:t.toCharArray()){
            hash[c-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i]!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsAnagram().isAnagram("a", "ab"));
    }
}
