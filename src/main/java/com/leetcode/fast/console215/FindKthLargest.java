package com.leetcode.fast.console215;

import java.util.Random;

/**
 * 快排选择+二分
 * 第k大的元素下标为len-k
 * @author : cnafan
 * @date : 2021-08-25 16:28
 **/
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int target=nums.length-k;
        while (left < right) {
            int mid = partition(nums, left, right);
            if (mid == target) {
                return nums[mid];
            } else if (mid < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }
    int partition(int[] nums, int left, int right) {
        int pivot = left, temp = nums[pivot];
        while (left < right) {
            while (left < right && temp <= nums[right]) {
                right--;
            }
            while (left < right && nums[left] <= temp) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, left, pivot);
        return left;
    }

    void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
