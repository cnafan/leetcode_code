package com.leetcode.array.interview0101;

import java.util.Arrays;

public class IsUnique {
    public static void main(String[] args) {
        System.out.println(new IsUnique().isUnique("leetcode"));
    }

    public boolean isUnique(String astr) {
        char[] a=astr.toCharArray();
        Arrays.sort(a);
        for (int i = 0; i < a.length-1; i++) {
            if (a[i]==a[i+1]){
                return false;
            }
        }
        return true;
    }
}
