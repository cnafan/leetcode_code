package com.leetcode.array.interview0102;

public class CheckPermutation {
    public static void main(String[] args) {
        System.out.println(new CheckPermutation().checkPermutation("abc", "bad"));
    }
    public boolean checkPermutation(String s1, String s2) {
        if (s1.length()!=s2.length()){
            return false;
        }
        int[] hash1=new int[101];
        int[] hash2=new int[101];
        for (int i = 0; i < s1.length(); i++) {
            hash1[s1.charAt(i)-'a']++;
            hash2[s2.charAt(i)-'a']++;
        }
        for (int i = 0; i < hash1.length; i++) {
            if (hash1[i]!=hash2[i]){
                return false;
            }
        }
        return true;
    }
}
