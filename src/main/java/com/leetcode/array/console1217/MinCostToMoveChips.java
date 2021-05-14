package com.leetcode.array.console1217;

public class MinCostToMoveChips {
    public static void main(String[] args) {
        System.out.println(new MinCostToMoveChips().minCostToMoveChips(new int[]{2,2,2,3,3}));

    }
    public int minCostToMoveChips(int[] position) {
        int num1=0,num2=0;
        for (int i : position) {
            if (i%2==0){
                num2++;
            }
            else {
                num1++;
            }
        }

        return Math.min(num1,num2);

    }
}
