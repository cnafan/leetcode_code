package com.leetcode.dp.console509;

public class Fib {
    public static void main(String[] args) {
        System.out.println(new Fib().fib(30));
    }
    public int fib(int N) {
        int[] fibs=new int[31];
        fibs[0]=0;
        fibs[1]=1;

        for (int i = 2; i < fibs.length; i++) {
            fibs[i]=fibs[i-1]+fibs[i-2];
        }
        return fibs[N];
    }
}
