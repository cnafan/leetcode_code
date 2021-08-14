package com.offer.offer40;

import sun.applet.Main;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class GetLeastNumbers {

    /**
     * 快排切分
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || arr.length < 1 || k < 1) {
            return new int[]{};
        }
        partitionArray(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public void partitionArray(int[] arr, int left, int right, int k) {
        int index = patition(arr, left, right);
        if (index == k) {
            return;
        }
        if (index > k) {
            // 一定在左侧
            partitionArray(arr, left, index - 1, k);
        } else {
            // 不够还需要在右侧找k-index个
            partitionArray(arr, index + 1, right, k);
        }
    }

    public int patition(int[] arr, int left, int right) {
        int pivot = arr[left], temp = left;
        while (left < right) {
            // 相同的也跳过
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            swap(arr, left, right);
        }
        swap(arr, left, temp);
        return left;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GetLeastNumbers().getLeastNumbers2(new int[]{2, 5, 2, 1, 3, 3, 9}, 3)));
    }

    // 优先队列实现的最大堆
    // 如果不到k个，直接添加，如果超了就弹出，然后添加
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() > num) {
                queue.poll();
                queue.add(num);
            }
        }
        int[] res = new int[queue.size()];
        for (int i = 0; i < queue.size(); i++) {
            res[i] = queue.poll();
        }
        return res;
    }

}
