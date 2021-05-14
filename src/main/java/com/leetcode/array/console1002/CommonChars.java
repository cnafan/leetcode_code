package com.leetcode.array.console1002;

import java.util.ArrayList;
import java.util.List;

public class CommonChars {

    public static void main(String[] args) {

        for (String commonChar : new CommonChars().commonChars(new String[]{"cool","lock","cook"})) {
            System.out.println(commonChar);
        }
    }

    public int[] getahash(String a) {
        int[] ahash = new int[26];
        for (int j = 0; j < a.length(); j++) {
            ahash[a.charAt(j) - 'a']++;
        }
        return ahash;
    }

    public int getMin(int[][] hashs, int pos) {
        int min = hashs[0][pos];
        for (int i = 1; i < hashs.length; i++) {
            if (hashs[i][pos] < min) {
                min = hashs[i][pos];
            }
        }
        return min;

    }

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();

        //统计每个字符串的哈希数组
        int[][] ahashs = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            ahashs[i] = getahash(A[i]);
        }

        //统计每个哈希数组中26个位置的最小值
        int[] eachhashcount = new int[26];
        for (int j = 0; j < eachhashcount.length; j++) {
            eachhashcount[j] = getMin(ahashs, j);
        }
        //遍历并打印
        for (int i = 0; i < eachhashcount.length; i++) {
            for (int j = 0; j < eachhashcount[i]; j++) {
                res.add(String.valueOf(((char) (i + 'a'))));
            }
        }

        return res;
    }
}
