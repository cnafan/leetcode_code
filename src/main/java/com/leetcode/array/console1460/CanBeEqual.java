package com.leetcode.array.console1460;

import java.util.Arrays;

public class CanBeEqual {
    public static void main(String[] args) {

        System.out.println(new CanBeEqual().canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}
