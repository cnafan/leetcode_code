package com.leetcode.stack.console503;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2*nums.length-1; i++) {
            while (!stack.isEmpty()&&nums[stack.peek()]<nums[i%nums.length]){
                res[stack.pop()]=nums[i%nums.length];
            }
            stack.push(i%nums.length);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElements().nextGreaterElements(new int[]{1, 2, 1})));
    }
}
