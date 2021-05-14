package com.leetcode.string.console917;

import java.util.Arrays;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int i = 0, j = S.length() - 1;
        while (i < j) {
            while (!isCase(chars[i]) && i < j) i++;
            while (!isCase(chars[j]) && i < j) j--;
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    public boolean isCase(Character c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    public static void main(String[] args) {
        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
