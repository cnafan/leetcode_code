package com.leetcode.string.console557;

import com.leetcode.string.offer58.ReverseLeftWords;

public class ReverseWords {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            for (int j = strings[i].length()-1; j >=0; j--) {
                res.append((char)(strings[i].charAt(j)));
            }
            if (i!= strings.length-1)
            res.append(" ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("Let's take LeetCode contest"));

    }
}
