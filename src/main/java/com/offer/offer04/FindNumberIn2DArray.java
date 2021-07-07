package com.offer.offer04;

/**
 * 1.双指针法搜索二位矩阵,使用二分法查找矩阵，即从左下角开始查找，小于的往上搜索，大于往右搜索
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 只需检测是否为空，即一维数组也可搜索
        if (matrix == null || matrix.length < 1) {
            return false;
        }
        int row = matrix.length - 1, column = 0;
        while (row >= 0 && column < matrix[0].length) {
            if (matrix[row][column] > target) {
                row--;
            } else if (matrix[row][column] < target) {
                column++;
            } else {
                return true;
            }
        }
        return false;
    }
}
