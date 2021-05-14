package com.leetcode.math.console190;

public class ReverseBits {
    public int reverseBits(int n) {
        int res=0;

        for (int i = 0; i < 32; i++) {
             res<<=1;
             res+=n&1;
             n>>=1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(3));
    }
}
