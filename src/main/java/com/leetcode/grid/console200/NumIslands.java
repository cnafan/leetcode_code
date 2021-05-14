package com.leetcode.grid.console200;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.RecursiveTask;

public class NumIslands {
    /**
     * 使用dfs将走过的岛置为0
     * <p>
     * 时间复杂度：O(mn)
     *
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length, nc = grid[0].length;
        int res = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;

    }

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length, nc = grid[0].length;

        if (r < 0 || c < 0 | r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    /**
     * 广度优先遍历 (始终错误)
     * <p>
     * 时间复杂度：O(mn)
     *
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length, nc = grid[0].length;
        int res = 0;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    bfs(grid, i, j);

                }
            }
        }
        return res;
    }

    void bfs(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        int nr = grid.length, nc = grid[0].length;
        Queue<Integer> neighbors = new LinkedList<>();
        neighbors.add(i * nc + j);// 加入当前节点的id
        while (!neighbors.isEmpty()) {
            int id = neighbors.poll();
            int row = id / nc;
            int col = id % nc;
            if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                grid[row - 1][col] = '0';
                neighbors.offer((row - 1) * nc + col);
            }
            if (row + 1 < nr && grid[row + 1][col] == '1') {
                grid[row + 1][col] = '0';
                neighbors.offer((row + 1) * nc + col);
            }
            if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                grid[row][col - 1] = '0';
                neighbors.offer(row * nc + col - 1);
            }
            if (col + 1 < nr && grid[row][col + 1] == '1') {
                grid[row][col + 1] = '0';
                neighbors.offer(row * nc + col + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new NumIslands().numIslands2(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }


}
