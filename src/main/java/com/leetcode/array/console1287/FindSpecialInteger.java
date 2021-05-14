package com.leetcode.array.console1287;

public class FindSpecialInteger {
    public int findSpecialInteger(int[] arr) {
        int elen = arr.length / 4;
        int major = arr[0], count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (count > elen) {
                return major;
            }
            if (count == 0) {
                major = arr[i];
                count++;
                continue;
            }
            if (arr[i] == major) {
                count++;
            } else {
                count--;
            }

        }
        return major;
    }

    public static void main(String[] args) {
        System.out.println(new FindSpecialInteger().findSpecialInteger(new int[]{1, 2, 3, 4}));
    }
}
