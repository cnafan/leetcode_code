package com.offer.offer12;

/**
 * 回溯
 * 采用有返回值的
 * 设置used数组
 *
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        boolean[][] used=new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag= backtrace(board,word,0,used,i,j);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    boolean backtrace(char[][] board, String word, int index, boolean[][] used, int row , int col) {

        // 找到
        if (board[row][col] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }

        // 访问
        used[row][col] = true;
        boolean result = false;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] direction : directions) {
            int newi = row + direction[0], newj = col + direction[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!used[newi][newj]) {
                    boolean flag = backtrace(board, word, index + 1, used, newi, newj);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }

        //回溯
        used[row][col] = false;
        return result;
    }
}
