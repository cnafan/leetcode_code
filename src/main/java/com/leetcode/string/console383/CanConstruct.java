package com.leetcode.string.console383;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hashR=new int[26];
        int[] hashM=new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            hashR[ransomNote.charAt(i)-'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            hashM[magazine.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (hashR[i]>hashM[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanConstruct().canConstruct("aab", "aab"));
    }

}
