package com.offer.offer16;

public class MyPow {
    /**
     * 递归
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long nn = n;
        if (nn == 0) {
            return 1;
        }
        if (nn < 0) {
            nn = -n;
            x = 1 / x;
        }
        if ((nn & 1) == 1) {
            return x * myPow(x * x, (int) (nn >> 1));
        }
        return myPow(x * x, (int) (nn >> 1));
    }

    /**
     * 快速幂算法
     * 将幂值降下来
     * https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
     * x^11=x^5*x^5*x
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        long nn = n;
        if (nn == 0) {
            return 1.0;
        }
        if (nn < 0) {
            nn = -nn;
            x = 1 / x;
        }
        double res = 1.0;
        while (nn > 0) {
            if ((nn & 1) == 1) {
                res *= x;
            }
            x *= x;
            nn >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
