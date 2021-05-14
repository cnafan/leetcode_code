package com.leetcode.stack.console151;

import java.util.Stack;

public class ReverseWords {
    /**
     * 用双指针确定字符串
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        int slow = 0, fast = 0;
        while (slow != chars.length) {
            while (fast != chars.length && chars[fast] != ' ') {
                fast++;
            }
            stack.push(s.substring(slow, fast));
            while (fast != chars.length && chars[fast] == ' ') {
                fast++;
            }
            slow = fast;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());

            if (stack.size() != 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
//    public String reverseWords(String s) {
//        Stack<String> stack=new Stack<>();
//        s = s.trim();
//        String[] strings = s.split(" ");
//        for(String str:strings){
//            stack.push(str  );
//        }
//        StringBuilder stringBuilder=new StringBuilder();
//        while (!stack.isEmpty()) {
//            stringBuilder.append(stack.pop());
//
//            if (stack.size()!=0){
//                stringBuilder.append(" ");
//            }
//        }
//        return stringBuilder.toString();
//    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("  Bob    Loves  Alice   "));
    }
}
