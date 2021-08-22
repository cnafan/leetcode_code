package com.leetcode.dfs.console695;

/**
 * @author : cnafan
 * @date : 2021-08-22 11:51
 **/
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    int dfs = dfs(grid, i, j);
                    if (dfs > max) {
                        max = dfs;
                    }
                }
            }
        }
        return max;


    }

    int dfs(int[][] grid, int row, int column) {
        grid[row][column] = 2;
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        int res = 1;
        for (int[] direction : directions) {
            int newRow = row + direction[0], newColumn = column + direction[1];
            if (inArea(grid, newRow, newColumn) && grid[newRow][newColumn] == 1) {
                res += dfs(grid, newRow, newColumn);
            }
        }
        return res;
    }

    boolean inArea(int[][] grid, int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }

    public static void main(String[] args) {
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
    }

}
