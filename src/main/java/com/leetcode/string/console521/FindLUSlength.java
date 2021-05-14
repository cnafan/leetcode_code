package com.leetcode.string.console521;

public class FindLUSlength {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)){
            return -1;
        }else{
            return Math.max(a.length(), b.length());
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindLUSlength().findLUSlength("aba", "cdc"));
    }
}
