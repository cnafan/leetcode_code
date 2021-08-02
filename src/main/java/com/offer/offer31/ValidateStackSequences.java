package com.offer.offer31;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 初始化一个stack = []，和index = 0
 * 循环pushed数组进行入栈
 * 每次入栈完成后，while检查popped[index] 是否等于栈顶，
 * 若popped[index]等于栈顶，则stack持续出栈，并伴随index += 1
 * 最终检查index 是否等于len(popped)即可。
 *
 */
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return index == popped.length;

    }

    public static void main(String[] args) {
        System.out.println(new ValidateStackSequences().validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 2, 5, 3, 1}));
    }
}
