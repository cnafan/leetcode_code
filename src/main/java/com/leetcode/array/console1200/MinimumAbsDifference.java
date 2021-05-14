package com.leetcode.array.console1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list=new ArrayList<>();

        int min=arr[1]-arr[0];
        for (int i = 1; i < arr.length-1; i++) {
            int diff=arr[i+1]-arr[i];
            if (diff<min){
                min=diff;
            }
        }

        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i+1]-arr[i]==min){
                List<Integer>list1=new ArrayList<>();
                list1.add(arr[i]);
                list1.add(arr[i+1]);
                list.add(list1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumAbsDifference().minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
    }
}
