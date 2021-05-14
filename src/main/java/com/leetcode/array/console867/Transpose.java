package com.leetcode.array.console867;

import java.util.Arrays;

public class Transpose {
    public static void main(String[] args) {
        int[][] res = new Transpose().transpose(new int[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(Arrays.deepToString(res));
    }

    public int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}
