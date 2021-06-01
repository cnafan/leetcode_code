package com.leetcode.math.console7;

/**
 *
 * 主要是考虑溢出问题，以及有符号整数的范围
 * https://leetcode-cn.com/problems/reverse-integer/solution/hua-jie-suan-fa-7-zheng-shu-fan-zhuan-by-guanpengc/
 */
public class Reverse {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {

            int pop = x % 10;
            //  不超过2^31 =2,147,483,648 个位数是8, 32 位有符号整数的范围 [-2^31,2^31-1],所以个位数超过7即溢出  7也可以写成 Integer.MAX_VALUE % 10 ,同理-8为 Integer.MIN_VALUE % 10
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            res = res * 10 + pop;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(34));
    }
}
