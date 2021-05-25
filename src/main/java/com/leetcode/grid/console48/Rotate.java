package com.leetcode.grid.console48;

import java.util.Arrays;

/**
 * 情况一：顺时针转 90 度：先转置再左右镜像
 * 1 2 3               7 4 1
 * 4 5 6               8 5 2
 * 7 8 9               9 6 3
 * 情况二：顺时针转 180 度:先上下镜像，再左右镜像（先左右再上下也可）
 * 1 2 3               9 8 7
 * 4 5 6               6 5 4
 * 7 8 9               3 2 1
 * 情况三：顺时针转 270 度：先转置再上下镜像
 * 1 2 3              3 6 9
 * 4 5 6              2 5 8
 * 7 8 9              1 4 7
 */
public class Rotate {
    public void rotate(int[][] matrix) {

        // 矩阵转置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        // 矩阵镜像
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < (matrix[i].length)/2; j++) {
              int temp=  matrix[i][j];
              matrix[i][j]=matrix[i][matrix.length-j-1];
              matrix[i][matrix.length-j-1]=temp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Rotate().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }

}
