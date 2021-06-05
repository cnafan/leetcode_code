package com.leetcode.math.console384;

import java.util.Arrays;
import java.util.Random;

/**
 * 洗牌算法：对于数组种的每个元素，用一个随机的元素与之交换。
 */
class Solution {
    private int[] copy;
    private int[] arr;
    private int len;

    public Solution(int[] nums) {
        len=nums.length;
        copy = Arrays.copyOf(nums, len);
        arr= Arrays.copyOf(nums, len);
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return copy;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < len; i++) {
            swap(arr,i,new Random().nextInt(len));
        }
        return arr;
    }
    public void swap(int[] arr,int i ,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution(new int[]{4, 5, 7, 1}).shuffle()));
    }
}

