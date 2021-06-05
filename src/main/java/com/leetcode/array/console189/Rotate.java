package com.leetcode.array.console189;

import com.leetcode.dp.console198.Rob;

import java.util.Arrays;

public class Rotate {

    /**
     * 数组翻转
     * 空间复杂度：O(1)
     */

    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k, nums.length-1);
    }
    public void reverse(int[] arr,int start,int end){
        while (start < end) {
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    /**
     * 环状数组
     * 空间复杂度：O(n)
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        int[] doubleNums = new int[len * 2];
        k%=len;
        System.arraycopy(nums, 0, doubleNums, 0, len);
        System.arraycopy(nums, 0, doubleNums, len, len);
        System.out.println(Arrays.toString(doubleNums));
        System.arraycopy(doubleNums, len-k, nums, 0, len);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        new Rotate().rotate(new int[]{1},2);
    }
}
