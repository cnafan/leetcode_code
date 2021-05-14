package com.leetcode.array.console1380;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbers {
    public static void main(String[] args) {
        for (Integer luckyNumber : new LuckyNumbers().luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}})) {
            System.out.println(luckyNumber);
        }
    }
    public List<Integer> luckyNumbers (int[][] matrix) {

        List<Integer> list = new ArrayList<Integer>();
        int[] rowindex=new int[matrix.length];

        //查找每行最小的所在列标
        for (int i = 0; i < matrix.length; i++) {
            int min=matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j]<min){
                    min=matrix[i][j];
                    rowindex[i]=j;
                }
            }
        }
        // 遍历列是否为最大
        for(int i = 0;i<rowindex.length;i++) {
            boolean flag = true;
            for(int j = 0;j<rowindex.length;j++) {
                if(j==i) {
                    continue;
                }
                if(matrix[i][rowindex[i]]<=matrix[j][rowindex[i]]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                list.add(matrix[i][rowindex[i]]);
            }
        }

        return list;

    }
}
