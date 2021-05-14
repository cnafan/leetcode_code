package com.leetcode.array.console1304;

public class SumZero {
    public static void main(String[] args) {
        int[] res = new SumZero().sumZero(1);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public int[] sumZero(int n) {
        int[] res = new int[n];

        int add = 0;
        for (int i = 1; i < res.length; i++) {
            res[i] = i;
            add += i;
        }
        res[0] = -add;
        return res;
    }
}
