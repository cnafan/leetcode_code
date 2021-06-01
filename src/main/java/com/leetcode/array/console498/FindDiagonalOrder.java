package com.leetcode.array.console498;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 模拟
 * https://leetcode-cn.com/problems/diagonal-traverse/solution/chu-li-hao-si-chong-qing-kuang-ji-ke-by-xi7up/
 */
public class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length < 1) {
            return new int[]{};
        }
        List<Integer> res = new ArrayList<>();
        int m = mat.length, n = mat[0].length;
        int count = m * n;
        int i = 0, j = 0;
        for (int k = 0; k < count; k++) {
            res.add(mat[i][j]);
            //，左下角方向，
            if ((i + j) % 2 == 0) {
                // 到达最后一列，向下
                if (j == n - 1) {
                    i++;
                }
                // 到达第一行，向右
                else if (i == 0) {
                    j++;
                }
                // 向右上
                else {
                    i--;
                    j++;
                }
            } else {
                // 到达最后一行，向上
                if (i == m - 1) {
                    j++;
                }
                // 到达第一列，向下
                else if (j == 0) {
                    i++;
                }
                // 向左下
                else {
                    j--;
                    i++;
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindDiagonalOrder().findDiagonalOrder(new int[][]{{6, 9, 7}})));
    }

}
