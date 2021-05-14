package com.leetcode.array.console283;

public class MoveZeroes {
    public static void main(String[] args) {
        new MoveZeroes().moveZeroes(new int[]{1, 0});
    }

    public void moveZeroes(int[] nums) {
        int  j =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }

    }
}
