package com.leetcode.string.console394;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> stack_time = new Stack<>();
        Stack<String> stack_res = new Stack<>();
        int time = 0;
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_time.push(time);
                stack_res.push(res.toString());
                time = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                // 括号内重复部分
                StringBuilder tmp = new StringBuilder();
                int cur_time = stack_time.pop();
                for (int i = 0; i < cur_time; i++) {
                    tmp.append(res);
                }
                // 更新递归部分的内容 （核心） 例如3[b2[a]]
                res = new StringBuilder(stack_res.pop() + tmp);

            } else if (Character.isDigit(c)) {
                time = time * 10 +c-'0';
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }


//    public String decodeString2(String s) {
//        Stack<String> stack = new Stack<>();
//        StringBuilder res = new StringBuilder();
//        StringBuilder temp = new StringBuilder();
//        int num = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (Character.isDigit(c)) {
//                num = num * 10 + c - '0';
//            } else if (c == '[') {
//                stack.push(String.valueOf(num));
//                num = 0;
//            } else if (c == ']') {
//                stack.push(temp.toString());
//                temp = new StringBuilder();
//                String pop = stack.pop();
//                String time = stack.pop();
//                for (int j = 0; j < Integer.parseInt(time); j++) {
//                    res.append(pop);
//                }
//            } else {
//                temp.append(c);
//            }
//        }
//        return res.toString();
//    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
    }
}
