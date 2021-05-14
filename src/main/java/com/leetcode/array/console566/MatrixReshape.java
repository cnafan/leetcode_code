package com.leetcode.array.console566;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MatrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c) {
            return nums;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[][] res = new int[r][c];
        for (int[] num : nums) {
            for (int i : num) {
                queue.add(i);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.remove();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new MatrixReshape().matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
    }
}
