package com.leetcode.stack.console227;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : cnafan
 * @date : 2021-09-13 14:39
 **/
public class Calculate {
    public static void main(String[] args) {
        System.out.println(new Calculate().calculate("1*5"));
    }
    public int calculate(String s) {
        char preSign='+';
        int num=0;
        Deque<Integer> stack=new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                preSign = c;
                num = 0;
            }
        }
        int res=0;
        while (!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
