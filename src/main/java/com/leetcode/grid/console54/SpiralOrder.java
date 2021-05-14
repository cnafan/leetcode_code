package com.leetcode.grid.console54;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        if (matrix.length<1){
            return result;
        }
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1,element=matrix.length*matrix[0].length;
        while (element>0){
            for (int i = left; i <= right && element>0; i++) {
                result.add(matrix[top][i]);
                element--;
            }
            top++;
            for (int i = top; i <= bottom && element>0; i++) {
                result.add(matrix[i][right]);
                element--;
            }
            right--;
            for (int i = right; i >= left && element>0; i--) {
                result.add(matrix[bottom][i]);
                element--;
            }
            bottom--;
            for (int i = bottom; i >= top && element>0; i--) {
                result.add(matrix[i][left]);
                element--;
            }
            left++;
        }
            return result;
    }

    /**
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public static void main(String[] args) {
        System.out.println(new SpiralOrder().spiralOrder(new int[][]{}));
    }

}

