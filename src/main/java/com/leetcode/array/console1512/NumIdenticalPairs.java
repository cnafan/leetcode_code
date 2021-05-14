package com.leetcode.array.console1512;

public class NumIdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        int count=0;
        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]==nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumIdenticalPairs().numIdenticalPairs(new int[]{1}));
    }
}
