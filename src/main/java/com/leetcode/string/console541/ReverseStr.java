package com.leetcode.string.console541;

public class ReverseStr {
    public static void main(String[] args) {
        System.out.println(new ReverseStr().reverseStr("abcdefg",3));
    }

    public String reverseStr(String s, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length()-2*k; i += 2 * k) {
            index +=2*k;
            stringBuilder.append(reverse(s.substring(i, i + k)));
            stringBuilder.append(s.substring(i + k, i + 2 * k));
        }
        if (s.length() - index > k) {
            stringBuilder.append(reverse(s.substring(index, index + k)));
            stringBuilder.append(s.substring(index+k, s.length()));
        } else {
            stringBuilder.append(reverse(s.substring(index, s.length())));
        }
        return stringBuilder.toString();
    }

    public String reverse(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        String s1 = String.valueOf(chars);
        return s1;
    }

}
