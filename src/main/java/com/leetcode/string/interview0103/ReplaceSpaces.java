package com.leetcode.string.interview0103;

public class ReplaceSpaces {
    public static void main(String[] args) {
        System.out.println(new ReplaceSpaces()
                .replaceSpaces("               ", 0));
    }

    public String replaceSpaces(String S, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(S.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
