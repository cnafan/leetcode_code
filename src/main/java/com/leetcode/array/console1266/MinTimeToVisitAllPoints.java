package com.leetcode.array.console1266;

public class MinTimeToVisitAllPoints {
    public static void main(String[] args) {
        System.out.println(new MinTimeToVisitAllPoints().minTimeToVisitAllPoints(new int[][]{{3, 2}, {-2, 2}}));
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            res += caculate2point(points[i], points[i + 1]);
        }
        return res;
    }

    public int caculate2point(int[] start, int[] end) {
        int x = Math.abs(end[0] - start[0]);
        int y = Math.abs(end[1] - start[1]);
        return Math.min(x, y) + (Math.max(x, y) - Math.min(x, y));
    }
}
