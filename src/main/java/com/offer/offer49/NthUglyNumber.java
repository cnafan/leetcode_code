package com.offer.offer49;

import java.util.*;

public class NthUglyNumber {
    /**
     * 使用最小堆,
     * 质数的线性筛算法
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] factors = new int[]{2, 3, 5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        set.add(1L);
        queue.add(1L);
        int res = 0;
        for (int i = 0; i < n; i++) {
            long curr = queue.poll();
            res = (int) curr;
            for (int factor : factors) {
                long next = factor * curr;
                if (set.add(next)) {
                    queue.add(next);
                }
            }
        }
        return res;
    }

    /**
     * 三指针，
     *
     * @param n
     * @return
     */
    public int nthUglyNumber2(int n) {
        if (n < 0) {
            return 0;
        }
        int p2 = 0, p3 = 0, p5 = 0;
        int[] num = new int[n];
        Arrays.fill(num, 1);
        for (int i = 1; i < n; i++) {
            num[i] = Math.min(Math.min(2 * num[p2], 3 * num[p3]), 5 * num[p5]);
            if (num[i] == 2 * num[p2]) {
                p2++;
            }
            if (num[i] == 3 * num[p3]) {
                p3++;
            }
            if (num[i] == 5 * num[p5]) {
                p5++;
            }
        }
        return num[n - 1];
    }
}
