package com.leetcode.string.console345;

import java.util.Arrays;
import java.util.List;

public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(new ReverseVowels().reverseVowels("Anne, I vote more cars race Rome-to-Vienna."));
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Character[] yuan = new Character[]{'a', 'o', 'e', 'i', 'u', 'A', 'O','I', 'E', 'U'};
        List<Character> list = Arrays.asList(yuan);
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (!list.contains(chars[i])&&i<j)
            i++;
            while (!list.contains(chars[j])&&i<j)
            j--;
            if (chars[i]!=chars[j]) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            i++;
            j--;
        }
        return String.valueOf(chars);
    }
}
