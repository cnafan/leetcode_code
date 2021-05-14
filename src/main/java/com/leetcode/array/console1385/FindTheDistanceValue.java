package com.leetcode.array.console1385;

public class FindTheDistanceValue {
    public static void main(String[] args) {
        System.out.println(new FindTheDistanceValue().findTheDistanceValue(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2));
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean is = false;
            for (int i1 = 0; i1 < arr2.length&& !is; i1++) {
                if (Math.abs(arr1[i] - arr2[i1]) <= d) {
                    is = true;
                }

            }
            if (!is)
                count++;
        }
        return count;

    }
}
