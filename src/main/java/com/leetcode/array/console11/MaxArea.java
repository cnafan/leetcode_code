package com.leetcode.array.console11;

public class MaxArea {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            if (max < area) {
                max=area;
            }
            if (height[left]>height[right]){
                right--;
            }else {
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[]{1,2,1}));
    }
}
