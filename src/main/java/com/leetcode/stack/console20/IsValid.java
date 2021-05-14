package com.leetcode.stack.console20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {
    private Stack<Character> stack;

    public boolean isValid2(String s) {
        stack = new Stack<>();
        boolean res = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                res = stack.pop() == '(';
            } else if (c == '}') {
                res = stack.pop() == '{';
            } else if (c == ']') {
                res = stack.pop() == '[';
            }
            if (!res)
                return false;
        }
        return stack.isEmpty();

    }

    public boolean isValid(String s) {
        if (s.length()%2==1){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("}"));
    }

}
