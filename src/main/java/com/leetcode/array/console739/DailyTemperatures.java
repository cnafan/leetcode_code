package com.leetcode.array.console739;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class DailyTemperatures {

    /**
     * 单调栈:用下标存储，保证栈中都是单调递减的，因此如果有大于栈顶元素的元素出现，意味着第一个比他大的元素就是该元素，此时计算出下标差，即可。
     * 如果栈为空，直接填入；不为空时取出栈顶比较，若大于栈顶，计算差值，最后没有满足条件的时候入栈；若小于栈顶直接入栈
     *
     * 时间复杂度：O(n)
     *
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty() || temperatures[stack.peek()] > temperatures[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    Integer pop = stack.pop();
                    res[pop] = i - pop;
                }
                stack.push(i);

            }
        }
        res[temperatures.length - 1] = 0;
        return res;
    }

    /**
     * 暴力
     * 对于每个数，向后遍历，只要获取第一个大于它所经过的数的个数
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int len = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = len + 1;
                    break;
                } else {
                    len++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
