package com.leetcode.array.console1394;

public class FindLucky {
    public int findLucky(int[] arr) {
        int[] hash=new int[501];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        for (int i = hash.length-1; i > 0; i--) {
            if (i==hash[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindLucky().findLucky(new int[]{2,2,3,4}));
    }
}
