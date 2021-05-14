package com.leetcode.binary.console704;

public class Search {
    public int search(int[] nums, int target) {
        // 右边界可以取到[0,n-1]
        int left = 0, right = nums.length - 1;
        while (left <= right) { // 大于等于
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1; //[0,mid-1],统一右边界能取到
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        // 右边界不可以取到，[0,n)
        int left = 0, right = nums.length - 1;
        while (left < right) {// 大于
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid; //[0,mid-1],统一右边界能取到
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Search().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }
}
