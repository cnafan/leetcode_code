package com.leetcode.array.console912;


import java.util.Arrays;
import java.util.Random;

/**
 * 快排
 * 时间复杂度：O(nlogn)
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int index = partition(nums, left, right);
            quickSort(nums, left, index - 1);
            quickSort(nums, index + 1, right);
        }
    }

    // 填坑方法
    public int partition2(int[] nums, int left, int right) {
        // 加入随机 ，避免退化O(n2)
        if (right > left)
            swap(nums, left, left+1+new Random().nextInt(right - left));

        int pivot = nums[left];
        int index = left;

        for (int i = left + 1; i <= right; i++) {
            if (pivot > nums[i]) {
                index++;
                swap(nums, i, index);
            }
        }
        swap(nums, index, left);
        return index;
    }

    // 交换方法
    public int partition(int[] nums, int left, int right) {
        // 加入随机 ，避免退化O(n2)
        if (right > left)
            swap(nums, left, left+1+new Random().nextInt(right - left));

        int pivot=nums[left];
        int temp=left;

        while (left<right){
            while (left<right&&nums[right]>=pivot){
                right--;
            }
            while (left<right&&nums[left]<=pivot){
                left++;
            }
            if (left>=right){
                break;
            }
                swap(nums,left,right);

        }
        swap(nums,left,temp);
        return left;
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArray().sortArray(new int[]{8,-7,-1,-1,0,2, 5, 3, 3, 1, 9})));
    }
}
