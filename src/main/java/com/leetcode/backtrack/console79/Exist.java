package com.leetcode.backtrack.console79;

public class Exist {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag=backtrace(board,word,0,visited,i,j);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrace(char[][] board, String word, int index, boolean[][] visited, int i, int j) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        //

        boolean result = false;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            int newi = i + direction[0], newj = j + direction[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = backtrace(board, word, index + 1, visited, newi, newj);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }

        //
        visited[i][j] = false;
        return result;

    }

    public static void main(String[] args) {
        System.out.println(new Exist().exist(new char[][]{{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}}, "see"));

    }
}
