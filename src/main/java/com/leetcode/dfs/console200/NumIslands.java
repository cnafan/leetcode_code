package com.leetcode.dfs.console200;

/**
 * 使用dfs遍历,如果遍历过的进行标记，每次遇到新的陆地就统计
 *
 * @author : cnafan
 * @date : 2021-08-22 09:51
 **/
public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '2';
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for (int[] direction : directions) {
            int newRow = i + direction[0], newColumn = j + direction[1];
            // 如果使用方向数组且提前判断，若不提前判断则判断需要写在递归出口。
            if (inArea(grid, newRow, newColumn) && grid[newRow][newColumn] == '1') {
                dfs(grid, newRow, newColumn);
            }
        }
    }

    boolean inArea(char[][] grid, int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }

    public static void main(String[] args) {
        System.out.println(new NumIslands().numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));

    }
}
