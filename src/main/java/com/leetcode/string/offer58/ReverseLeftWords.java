package com.leetcode.string.offer58;

public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n).concat(s.substring(0,n));
    }

    public static void main(String[] args) {
        System.out.println(new ReverseLeftWords().reverseLeftWords("abcdefg", 2));

    }
}
