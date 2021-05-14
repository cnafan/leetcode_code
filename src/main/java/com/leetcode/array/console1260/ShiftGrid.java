package com.leetcode.array.console1260;

import java.util.ArrayList;
import java.util.List;

public class ShiftGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res=new ArrayList<>();
        int numRows=grid.length,numCols=grid[0].length;
        for (int row = 0; row < numRows; row++) {
            List<Integer> newRow = new ArrayList<>();
            res.add(newRow);
            for (int col = 0; col < numCols; col++) {
                newRow.add(0);
            }
        }

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int newCol = (col + k) % numCols;
                int wrapAroundCount = (col + k) / numCols;
                int newRow = (row + wrapAroundCount) % numRows;
                res.get(newRow).set(newCol, grid[row][col]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ShiftGrid().shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},1));

    }
}
