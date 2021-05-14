package com.leetcode.array.console13;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
        System.out.println(new RomanToInteger().romanToInt_leetcode("MCMXCIV"));
    }

    public int romanToInt_leetcode(String s){
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public int romanToInt(String s) {
        String ro = "IVXLCDM";
        int res = 0;
        int[] in = {1, 5, 10, 50, 100, 500, 1000};
        int index=0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                res -= in[ro.indexOf(s.charAt(i))];
            } else {
                res += in[ro.indexOf(s.charAt(i))];
            }
            index = i;
        }
        res += in[ro.indexOf(s.charAt(index))];
        return res;
    }
}
