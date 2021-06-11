package com.leetcode.array.console739;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    // 栈
//    public int[] dailyTemperatures(int[] temperatures) {
//
//    }
    /**
     * 对于每个数，向后遍历，只要获取第一个大于它所经过的数的个数
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int len = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = len+1;
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
    }
}
