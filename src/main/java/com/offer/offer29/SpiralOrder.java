package com.offer.offer29;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {

        List<Integer> result=new ArrayList<>();
        if (matrix == null||matrix.length<1) {
            return new int[]{};
        }
        int elements = matrix.length * matrix[0].length;
        int left = 0, right = matrix[0].length - 1, start = 0, end = matrix.length - 1;
        while (elements > 0) {
            for (int i = left; i <= right && elements > 0; i++) {
                result.add(matrix[start][i]);
                elements--;
            }
            start++;
            for (int i = start; i <= end && elements > 0; i++) {
                result.add(matrix[i][right]);
                elements--;
            }
            right--;
            for (int i = right; i >= left && elements > 0; i--) {
                result.add(matrix[end][i]);
                elements--;
            }
            end--;
            for (int i = end; i >= start && elements > 0; i--) {
                result.add(matrix[i][left]);
                elements--;
            }
            left++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
