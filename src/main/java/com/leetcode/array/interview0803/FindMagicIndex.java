package com.leetcode.array.interview0803;

public class FindMagicIndex {
    public static void main(String[] args) {
        System.out.println(new FindMagicIndex().findMagicIndex(new int[]{1,3,3,4,6,6,6}));
    }
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==i){
                return i;
            }
            if (nums[i]>i){
                i=nums[i]-1;
            }
        }
        return -1;
    }
}
