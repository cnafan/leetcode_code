package com.leetcode.array.console905;

public class SortArrayByParity {
    public static void main(String[] args) {
        for (int i : new SortArrayByParity().sortArrayByParity(new int[]{0})) {
            System.out.println(i);
        }

    }

    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            while (A[i] % 2 == 0&&i<j) {
                i++;
            }
            while (A[j] % 2 == 1&&i<j) {
                j--;
            }
            int temp=A[i];
            A[i]=A[j];
            A[j]=temp;
            i++;j--;
        }
        return A;
    }
}
