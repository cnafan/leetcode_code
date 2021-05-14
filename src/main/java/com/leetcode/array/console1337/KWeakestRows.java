package com.leetcode.array.console1337;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KWeakestRows {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new KWeakestRows().kWeakestRows(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}}, 3)));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] count = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                count[i][0]=i;
                if (mat[i][j] == 1) {
                    count[i][1]++;
                }
            }
        }

        // 自定义排序
        Arrays.sort(count,(o1,o2)-> o1[1]-o2[1]);

        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=count[i][0];
        }

        return res;
    }
}
