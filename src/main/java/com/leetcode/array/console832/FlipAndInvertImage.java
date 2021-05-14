package com.leetcode.array.console832;

public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length / 2; j++) {
                int temp = replace(A[i][j]);
                A[i][j] = replace(A[i][A[i].length - j - 1]);
                A[i][A[i].length - j - 1] = temp;
            }
            if (A[i].length % 2 == 1) {
                A[i][A[i].length / 2] = replace(A[i][A[i].length / 2]);
            }
        }
        return A;
    }
    public int[][] flipAndInvertImage2(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (A[i].length+1) / 2; j++) {
                int temp = replace(A[i][j]);
                A[i][j] = replace(A[i][A[i].length - j - 1]);
                A[i][A[i].length - j - 1] = temp;
            }
        }
        return A;
    }
    //位运算 ^x :和x相同则为0，否则为1
    public int[][] flipAndInvertImage3(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (A[i].length+1) / 2; j++) {
                int temp = A[i][j]^1;
                A[i][j] = A[i][A[i].length - j - 1]^1;
                A[i][A[i].length - j - 1] = temp;
            }
        }
        return A;
    }

    public int replace(int zeroone) {
        return zeroone == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        //[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
        int[][] res = new FlipAndInvertImage().flipAndInvertImage3(new int[][]{{1,1,0,0}, {1,0,0,1}, {0,1,1,1},{1,0,1,0}});
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
