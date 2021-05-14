package com.leetcode.array.console59;

import java.util.Arrays;

/**
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 *
 * 输入：n = 1
 * 输出：[[1]]
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] result=new int[n][n];
        int left=0,right=n-1,top=0,bottom=n-1,i=1;
        while (i<=n*n) {
            for (int j = left; j <= right; j++) {
                result[top][j] = i;
                i++;
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                result[j][right] = i;
                i++;
            }
            right--;
            for (int j = right; j >= left; j--) {
                result[bottom][j] = i;
                i++;
            }
            bottom--;
            for (int j = bottom; j >= top; j--) {
                result[j][left] = i;
                i++;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new GenerateMatrix().generateMatrix(2)));
    }
}
