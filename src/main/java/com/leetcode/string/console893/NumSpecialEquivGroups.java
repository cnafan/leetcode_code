package com.leetcode.string.console893;

public class NumSpecialEquivGroups {

    public int numSpecialEquivGroups(String[] A) {
        int res = 0;
        int[] A_use = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if (A_use[i] != 1) {
                for (int j = i+1; j < A.length; j++) {
                    if (A_use[j] != 1) {
                        if (isSpecialEqual(A[i], A[j])) {
                            A_use[j] = 1;
                        }
                    }
                }
                A_use[i] = 1;
                res++;
            }
        }
        return res;
    }

    public boolean isSpecialEqual(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int[] hash_ji = new int[27];
        int[] hash_ou = new int[27];
        for (int i = 0; i < a.length(); i++) {
            if (i % 2 == 0)
                hash_ou[a.charAt(i) - 'a']++;
            else
                hash_ji[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            int index = b.charAt(i) - 'a';
            if (i % 2 == 0) {
                if (hash_ou[index] == 0) {
                    return false;
                }
                hash_ou[index]--;
            } else {
                if (hash_ji[index] == 0) {
                    return false;
                }
                hash_ji[index]--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (i % 2 == 0) {
                if (hash_ou[i] < 0) {
                    return false;
                }
            } else {
                if (hash_ji[i] < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NumSpecialEquivGroups().numSpecialEquivGroups(new String[]{"abc","acb","bac","bca","cab","cba"}));
    }
}
