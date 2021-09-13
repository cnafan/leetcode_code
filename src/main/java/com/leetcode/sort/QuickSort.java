package com.leetcode.sort;

import java.util.Arrays;

/**
 * @author : cnafan
 * @date : 2021-09-10 21:59
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] test = {9, 7, 4, 23, 5, 11, 3, 3};
        quickSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }

    static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr,left,right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    static int partition(int[] arr,int left,int right) {
        int pivot = left;
        while (left < right) {
            while (left < right && arr[right] >= arr[pivot]) {
                right--;
            }
            while (left < right && arr[left] <= arr[pivot]) {
                left++;
            }
            swap(arr, left, right);
        }
        swap(arr, left, pivot);
        return left;
    }

    static public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
