package com.leetcode.sort;

import java.util.Arrays;

/**
 * 修改原数组版本
 *
 * @author : cnafan
 * @date : 2021-09-10 20:15
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] test=new int[]{1,2,4,6,3,0,9};
        mergeSort(test);
        System.out.println(Arrays.toString(test));
    }

    public static void mergeSort(int[] arr) {
        int left = 0, right = arr.length - 1;
        int[] res = sort(arr, left, right);
        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    public static int[] sort(int[] arr, int left, int right) {
        if (left == right) {
            return new int[]{arr[left]};
        }
        int mid = left + (right - left) / 2;
        int[] lefts = sort(arr, left, mid);
        int[] rights = sort(arr, mid + 1, right);
        return merge(lefts, rights);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length + arr2.length];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 <arr1.length && index2 <arr2.length) {
            if (arr1[index1] >= arr2[index2]) {
                temp[index] = arr2[index2++];
            } else {
                temp[index] = arr1[index1++];
            }
            index++;
        }
        while (index2 < arr2.length)
            temp[index++] = arr2[index2++];
        while (index1 < arr1.length)
            temp[index++] = arr1[index1++];
        return temp;
    }
}
