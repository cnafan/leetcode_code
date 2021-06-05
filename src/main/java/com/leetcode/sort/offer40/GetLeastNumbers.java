package com.leetcode.sort.offer40;

import java.util.Arrays;

public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k==0){
            return new int[0];
        }else if (k>=arr.length){
            return arr;
        }
        partitionArray(arr,0,arr.length-1,k);
        return Arrays.copyOf(arr,k);
    }

    /**
     * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/tu-jie-top-k-wen-ti-de-liang-chong-jie-fa-you-lie-/
     * @param arr
     * @param left
     * @param right
     * @param k
     */
    void partitionArray(int[] arr, int left, int right, int k) {
        int index = partition(arr, left, right);
        if (index == k) {
            return;
        } else if (index < k) {
            // 不够还需要在右侧找k-index个
            partitionArray(arr, index + 1, right, k);
        } else {
            // 一定在左侧
            partitionArray(arr, left, index - 1, k);
        }
    }

    int partition(int[] arr, int left, int right) {
        int temp = left, pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left >= right) {
                break;
            }
            swap(arr, left, right);
        }
        swap(arr, left, temp);
        return left;
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers(new int[]{3,2,1}, 2)));
    }
}
