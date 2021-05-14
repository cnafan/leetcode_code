package com.leetcode.dp.console303;

import java.util.Arrays;

public class NumArray {
    // 暴力法
//    private int[] data;
//
//    public NumArray(int[] nums) {
//        data = nums;
//    }
//
//    public int sumRange(int i, int j) {
//        int res = 0;
//        for (int k = i; k <= j; k++) {
//            res += data[k];
//        }
//        return res;
//    }
//

    // 优化1
//    Map<Pair<Integer, Integer>, Integer> map = new HashMap();
//
//    public NumArray(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int tmp=0;
//            for (int j = i; j < nums.length; j++) {
//                tmp+=nums[j];
//                map.put(new Pair<>(i,j),tmp );
//            }
//        }
//    }
//    public int sumRange(int i, int j) {
//        return map.get(new Pair<>(i,j));
//    }
//

    // 优化2

    private int[] sum;
    public NumArray(int[] nums) {
        sum=new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sum[i+1]=sum[i]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{-2, 0, 3, -5, 2, -1}, {0, 2}, {2, 5}, {0, 5}};
        int[] res = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            res[i] = new NumArray(nums[0]).sumRange(nums[i][0], nums[i][1]);
        }
        System.out.println(Arrays.toString(res));
    }
}
