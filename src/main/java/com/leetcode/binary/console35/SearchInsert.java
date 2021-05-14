package com.leetcode.binary.console35;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (nums[nums.length-1]<target){
            return nums.length;
        }
        // 定义区间
        int low=0,high=nums.length-1;
        while (low<high){
            int mid=low+(high-low)/2;
            // 严格小于 target 的元素一定不是解
            if (nums[mid]<target){
                low=mid+1;
            }else if (nums[mid]>=target){
                high=mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsert().searchInsert(new int[]{1,3,5,6},6));
    }
}
