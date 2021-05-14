package com.leetcode.array.interview1704;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum=0;
        int n=nums.length;
        for (int num : nums) {
            sum+=num;
        }
        return n*(1+n)/2-sum;
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
