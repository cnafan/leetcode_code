package com.leetcode.array.console1122;

import java.util.Arrays;

public class RelativeSortArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new RelativeSortArray().relativeSortArray(new int[]{2,3,1,3,2,0,4,6,0,7,9,2,19}, new int[]{2,0,1,4,3,9,6})));
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res=new int[arr1.length];
        int indexres=0;
        int[] hash=new int[1001];

        // 统计arr1中元素出现的次数
        for (int k : arr1) {
            hash[k]++;
        }
        // 按出现次数填充
        for (int k : arr2) {
            while (hash[k]>0){
                res[indexres++] = k;
                hash[k]--;
            }
        }

        for (int i = 0; i < hash.length; i++) {
            while (hash[i]>0){
                res[indexres++]=i;
                hash[i]--;
            }
        }

        return res;

    }
}
