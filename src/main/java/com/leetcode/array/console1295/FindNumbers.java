package com.leetcode.array.console1295;

public class FindNumbers {
    public int findNumbers(int[] nums) {
        int res=0;
        for (int num : nums) {
            if(is2(num)){
                res++;
            }
        }
        return res;
    }

    public boolean is2(int num) {
        int in = 0;
        while (num != 0) {
            num /= 10;
            in++;
        }
        return in % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(new FindNumbers().findNumbers(new int[]{12, 345, 2, 6, 7896}));
    }
}
