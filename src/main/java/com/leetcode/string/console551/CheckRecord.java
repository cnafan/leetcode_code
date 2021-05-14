package com.leetcode.string.console551;

public class CheckRecord {
    public boolean checkRecord(String s) {
        int a = 0;
        for (int i = 0; i < s.length()&&a<2; i++) {
            if (s.charAt(i) == 'A') {
                a++;
            }
            if(i+3<=s.length()&&s.charAt(i)=='L'&&s.charAt(i+1)=='L'&&s.charAt(i+2)=='L'){
                return false;
            }
        }
        return a<2;
    }

    public static void main(String[] args) {
        System.out.println(new CheckRecord().checkRecord("PPALLL"));
    }
    /**
     * PPALLP
     * PPALLL
     * LL
     * LLL
     * LALL
     */
}
