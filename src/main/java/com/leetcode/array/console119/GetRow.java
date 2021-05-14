package com.leetcode.array.console119;

import java.util.ArrayList;
import java.util.List;

public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        rowIndex += 2;
        int[][] res = new int[rowIndex][rowIndex];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            if (i == rowIndex - 1) {
                list.add(1);
            }
            res[i][0] = 1;
            for (int j = 1; j < i; j++) {
                if (i == rowIndex - 1) {
                    list.add(res[i - 1][j - 1] + res[i - 1][j]);
                }
                res[i][j] = res[i - 1][j - 1] + res[i - 1][j];

            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new GetRow().getRow(0));
    }
}
