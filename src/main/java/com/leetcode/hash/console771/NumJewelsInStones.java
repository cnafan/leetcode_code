package com.leetcode.hash.console771;

public class NumJewelsInStones {
    public static void main(String[] args) {
        System.out.println(new NumJewelsInStones().numJewelsInStones("aA", "aAAbbbb"));

    }

    public int numJewelsInStones(String J, String S) {
        int[] hash = new int[52];
        for (int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);
            if (temp >= 'a' && temp <= 'z')
                hash[temp - 'a']++;
            else if (temp >= 'A' && temp <= 'Z')
                hash[temp - 'A' + 26]++;
        }
        int res=0;
        for (int i = 0; i < J.length(); i++) {
            char temp=J.charAt(i);
            if (temp >= 'a' && temp <= 'z')
                res+=hash[temp-'a'];
            else if (temp >= 'A' && temp <= 'Z')
                res+=hash[temp - 'A' + 26];
        }
        return res;
    }
}
