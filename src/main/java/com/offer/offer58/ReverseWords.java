package com.offer.offer58;

import java.util.*;

public class ReverseWords {
    /**
     * @param s
     * @return
     * @deprecated
     */
    public String reverseWords2(String s) {
        s = s.trim();
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals("")){
                // 遇到空单词则跳过
                continue;
            }
            stringBuilder.append(strings[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder stringBuilder = new StringBuilder();
        int right = s.length() - 1, left = right;
        while (left >= 0) {
            // 找到首个空格
            while (left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            // 添加单词
            stringBuilder.append(s, left + 1, right + 1).append(" ");
            // 跳过空格
            while (left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            right = left;
        }
        return stringBuilder.toString().trim();

    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords2("a good   example"));
    }
}
