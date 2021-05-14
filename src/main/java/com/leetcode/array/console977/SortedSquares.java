package com.leetcode.array.console977;

import java.util.Arrays;

public class SortedSquares {
    public static void main(String[] args) {
         int[] res=new SortedSquares().sortedSquares(new int[]{-7,-3,2,3,11});
        for (int re : res) {
            System.out.println(re);
        }
    }
    public int[] sortedSquares(int[] A) {
        int[] AA=new int[A.length];
        for (int i = 0; i < A.length; i++) {
            AA[i]=A[i]*A[i];
        }
        Arrays.sort(AA);
        return AA;
    }
}
