package com.leetcode_twice.array.console215;

public class FindKthLarges {
    // 堆排



    // 快排划分+分治
    public int findKthLargest(int[] nums, int k) {
        int len=nums.length;
        int left=0,right=len-1;

        int target=len-k;
        while (true) {
            int index=partition(nums,left,right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left=index+1;
            }else {
                right=index-1;
            }
        }
    }

    int partition(int[] nums, int left, int right) {
        int pivot = nums[left];

        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (pivot > nums[i]) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, j, left);
        return j;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
