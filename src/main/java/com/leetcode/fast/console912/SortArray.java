package com.leetcode.fast.console912;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : cnafan
 * @date : 2021-08-25 16:59
 **/
public class SortArray {
    public int[] sortArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        quickSort(nums, left, right);
        return nums;
    }

    void quickSort(int[] nums, int left, int right) {
        if (left <= right) {//***************************************************************************
            int index = partition(nums, left, right);
            quickSort(nums, 0, index - 1);
            quickSort(nums, index + 1, right);
        }

    }

    int partition(int[] nums, int left, int right) {
        // 随机
        if (right > left)
            swap(nums, left, left + 1 + new Random().nextInt(right - left));

        int pivot = nums[left], temp = left;
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, left, temp);
        return left;
    }

    void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArray().sortArray(new int[]{5, 2, 3, 1})));
    }
}
