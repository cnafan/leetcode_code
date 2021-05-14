package com.leetcode.array.console985;

import java.util.Arrays;

public class SumEvenAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            A[queries[i][1]] += queries[i][0];
            int sum = 0;
            for (int k : A) {
                if (k % 2 == 0) {
                    sum += k;
                }
            }
            res[i] = sum;
        }
        return res;
    }

    public int[] sumEvenAfterQueries2(int[] A, int[][] queries) {
        int[] res = new int[A.length];
        int sum=0;
        for (int i : A) {
            sum+=i;
        }

        for (int i = 0; i < queries.length; i++) {
            int index=queries[i][1];
            int val=queries[i][0];
            if (A[index]%2==0&&val%2==0){
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SumEvenAfterQueries().sumEvenAfterQueries2(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}})));
    }
}
