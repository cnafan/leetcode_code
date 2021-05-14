package com.leetcode.array.console1450;

public class BusyStudent {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res=0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime<=endTime[i]&&queryTime>= startTime[i]){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new BusyStudent().busyStudent(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4));
    }
}
