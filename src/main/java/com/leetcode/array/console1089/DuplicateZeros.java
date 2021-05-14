package com.leetcode.array.console1089;

import java.util.Arrays;

public class DuplicateZeros {
    // 统计0的个数，即后移位数
    public void duplicateZeros(int[] arr) {
        int[] hash=new int[10];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        int zero=hash[0];

        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i]==0){
                zero--;
            }
            arr[i]=arr[i-zero];
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,0,2,3,0,4,5,0};
        new DuplicateZeros().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));

    }

}
