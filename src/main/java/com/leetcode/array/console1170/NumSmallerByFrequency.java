package com.leetcode.array.console1170;

import java.util.Arrays;

public class NumSmallerByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (String word : words) {
                if (hash(queries[i]) < hash(word)) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    public int hash(String word) {
        int[] hash = new int[27];
        for (int i = 0; i < word.length(); i++) {
            hash[word.charAt(i)-'a']++;
        }
        for (int j : hash) {
            if (j != 0) {
                return j;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NumSmallerByFrequency().numSmallerByFrequency(new String[]{"bbb","cc"}, new String[]{"a","aa","aaa","aaaa"})));
    }
}
