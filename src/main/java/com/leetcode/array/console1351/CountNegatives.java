package com.leetcode.array.console1351;

public class CountNegatives {
    public int countNegatives(int[][] grid) {
        int res = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] < 0) {
                    res += ints.length - j;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new CountNegatives().countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}}));
    }
}
