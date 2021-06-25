package com.leetcode.heap.console215;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.logging.Level;

public class FindKthLargest {

    /**
     * 采用小顶堆 ，维护k个最大的元素，堆顶为所有元素最小值
     * 优先队列实现小顶堆
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {

        PriorityQueue<Integer> heap=new PriorityQueue<>((n1,n2)->n1-n2);//小顶堆
//        PriorityQueue<Integer> queue=new PriorityQueue<>(Comparator.comparingInt(n -> n));

        for (int num:nums){
            heap.offer(num);
            if (heap.size()>k){
                heap.poll();
            }
        }
        return heap.peek();
    }


    /**
     * 采用快排，K次partition操作找到第k大的元素
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            }
            if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    /**
     * 一次切分操作保证一个元素放在正确的位置
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right) {
        // 设置一个pivot
        // 随机
        if (right>left) {
            swap(nums, left, left + 1 + new Random().nextInt(right - left));
        }
        int pivot = nums[left];

        // 一个萝卜一个坑
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, left);
        return j;
    }

    /**
     * 辅助函数
     *
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
