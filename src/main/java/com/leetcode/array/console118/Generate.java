package com.leetcode.array.console118;

import java.util.ArrayList;
import java.util.List;

public class Generate {

    public static void main(String[] args) {
        System.out.println(new Generate().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList();
        List<Integer> innerList;
        int[][] yh = new int[numRows][numRows];


        for (int i = 0; i < numRows; i++) {
            innerList = new ArrayList<>();
            yh[i][0] = 1;
            innerList.add(1);
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    yh[i][j] = 1;
                } else {
                    yh[i][j] = yh[i - 1][j] + yh[i - 1][j - 1];
                }
                innerList.add(yh[i][j]);
            }
            list.add(innerList);
        }
        return list;
    }

}
