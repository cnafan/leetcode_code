package com.leetcode.binary.console153;

import java.util.Arrays;

public class FindMin {

    /**
     * 二分查找
     *
     * 时间复杂度O(nlogn)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        // 排除
        while (left<right){
            int mid=left+(right-left)/2;
            if (nums[mid]<nums[right]){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return nums[left];
    }
    /**
     * 数组复制
     * 时间复杂度O(n)
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int[] nums2 = new int[nums.length * 2];
        System.arraycopy(nums, 0, nums2, 0, nums.length);
        System.arraycopy(nums, 0, nums2, nums.length, nums.length);
        System.out.println(Arrays.toString(nums2));
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i + 1] < nums2[i]) {
                return nums2[i + 1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindMin().findMin(new int[]{1,1}));
    }
}
