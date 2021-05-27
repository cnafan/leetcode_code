package com.leetcode.array.console179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 结果导向比较
 * ba>ab，则b>a
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String num : strNums) {
            stringBuilder.append(num);
        }
        // 过滤前导0
        int k=0;
        while (k<stringBuilder.length()-1&&stringBuilder.charAt(k)=='0'){
            k++;
        }
        return stringBuilder.substring(k);
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{0,0}));
    }
}
