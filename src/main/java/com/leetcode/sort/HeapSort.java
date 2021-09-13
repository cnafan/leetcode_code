package com.leetcode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author : cnafan
 * @date : 2021-09-10 22:14
 **/
public class HeapSort {
    public static void main(String[] args) {

        int[] tests = {4, 6, 8, 5, 9};
        sort(tests);
        System.out.println(Arrays.toString(tests));
    }

    public static void sort(int[] arr) {
        // 建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 调整堆结构
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //如果左子结点小于右子结点，k指向右子结点
            if (k+1<length&&arr[k]<arr[k+1]){
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }
        }
        arr[i]=temp;

    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
