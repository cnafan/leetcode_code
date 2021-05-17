package com.leetcode.array.console56;

import java.util.*;

public class Merge {
    /**
     * 合并两个区间的三种情况
     * <p>
     * https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));

        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > res[index][1]) {
                index++;
                res[index] = interval;
            } else {
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, index+1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Merge().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}})));
    }
}
