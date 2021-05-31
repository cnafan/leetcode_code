package com.leetcode.string.console227;

import java.util.Arrays;
import java.util.Stack;

public class Calculate {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        char presign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            // 求出数字
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i))) {
                switch (presign) {
                    case '+':
                    case '-':
                        stack.push(num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                presign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        for (int i = 0; i < stack.size(); i++) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Calculate().calculate(" 3+5 / 2 "));
    }
}
