package com.leetcode.string.console1309;

public class FreqAlphabets {
    public static void main(String[] args) {
        System.out.println(new FreqAlphabets().freqAlphabets("10#11#12"));
    }
    public String freqAlphabets(String s) {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i)=='#'){
                stringBuilder.append((char)(Integer.parseInt(s.substring(i-2,i))-10+'j'));
                i-=2;
            }else {
                stringBuilder.append((char)(Integer.parseInt(s.substring(i,i+1))-1+'a'));
            }
        }
       return stringBuilder.reverse().toString();
    }
}
