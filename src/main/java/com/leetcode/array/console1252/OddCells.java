package com.leetcode.array.console1252;

public class OddCells {
    public int oddCells(int n, int m, int[][] indices) {
        boolean []ncount=new boolean[n];
        boolean []mcount=new boolean[m];
        for (int[] indice : indices) {
            ncount[indice[0]]=!ncount[indice[0]];
            mcount[indice[1]]=!mcount[indice[1]];
        }
        int n_true=0,m_true=0,n_false=0,m_false=0;
        for (int i = 0; i < ncount.length; i++) {
            if (ncount[i]){
                n_true++;
            }
            else n_false++;
        }
        for (int i = 0; i < mcount.length; i++) {
            if (mcount[i]){
                m_true++;
            }
            else m_false++;
        }
        return n_false*m_true+n_true*m_false;
    }
    public static void main(String[] args) {
        System.out.println(new OddCells().oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));


    }
}
