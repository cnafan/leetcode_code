package com.leetcode.string.console1374;

public class GenerateTheString {
    public String generateTheString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        if (n == 0) {
            return "";
        } else if (n == 2) {
            return "ab";
        } else if (n % 2 == 0) {
            stringBuilder.append("a");
        }else {
            stringBuilder.append("b");
        }
        for (int i = 0; i < n-1; i++) {
            stringBuilder.append("b");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new GenerateTheString().generateTheString(8));
    }
}
