package com.leetcode.array.console1502;

import java.util.Arrays;

public class CanMakeArithmeticProgression {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff=arr[1]-arr[0];
        if (arr[arr.length-1]!=arr[0]+( arr.length-1)*diff){
            return false;
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i]!= arr[i-1]+diff){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanMakeArithmeticProgression().canMakeArithmeticProgression(new int[]{1,2,4}));

    }
}
