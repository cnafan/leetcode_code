package com.leetcode.array.console1480;

public class RunningSum {
    public static void main(String[] args) {
        int[] res=new RunningSum().runningSum(new int[]{3,1,2,10,1});
        for (int re : res) {
            System.out.print(re+" ");
        }

    }
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i]=nums[i-1]+nums[i];
        }
        return nums;
    }
}
