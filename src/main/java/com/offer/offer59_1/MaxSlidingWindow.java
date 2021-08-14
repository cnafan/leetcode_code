package com.offer.offer59_1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 用一个双向队列来存储滑动窗口的最大值，每滑动一次就记录一下可能的最大值（若直接出现一个比当前最大值还大的就替换，若出现一个小的就作为储备，以防下一次滑动窗口时，把最大值划出去）
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 在队列不为空的情况下，如果队列尾部的元素要比当前的元素小，或等于当前的元素
            // 那么为了维持从大到小的原则，我必须让尾部元素弹出
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 不走 while 的话，说明我们正常在队列尾部添加元素
            queue.addLast(i);
            // 如果滑动窗口已经略过了队列中头部的元素，则将头部元素弹出
            if (queue.peekFirst() == (i - k)) {
                queue.pollFirst();
            }
//            // 超出滑动窗口范围时，移除
//            if (!queue.isEmpty() && queue.peekFirst() <= i - k) {
//                queue.pollFirst();
//            }
//            if (queue.isEmpty()) {
//                // 队列空：填入
//                queue.offerLast(i);
//            } else if (nums[queue.peekFirst()] <= nums[i]) {
//                // 比最大值还要大：清空
//                queue.pollFirst();
//                if (!queue.isEmpty())
//                    queue.pollLast();
//                queue.offerLast(i);
//            } else if (queue.size() == 1 && nums[queue.peekFirst()] > nums[i]) {
//                // 比最大值小，无储备值：添加
//                queue.offerLast(i);
//            } else if (queue.size() == 2 && nums[queue.peekFirst()] > nums[i] && nums[queue.peekLast()] < nums[i]) {
//                // 比最大值小,但大于储备值:替换储备值
//                queue.pollLast();
//                queue.offerLast(i);
//
//
//            }
            if (i >= k - 1) {
                res[index++] = nums[queue.peekFirst()];
            }

        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3)));
//        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(new int[]{1,-1}, 1)));//[1,-1]
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0}, 4)));//[7,7,7,7,7]
    }

}
