package com.leetcode.binary.console162;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid + 1] < nums[mid]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new FindPeakElement().findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
