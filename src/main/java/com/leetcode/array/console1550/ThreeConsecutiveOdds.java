package com.leetcode.array.console1550;

public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length-2; i++) {
            if (arr[i]%2==1&&arr[i+1]%2==1){
                if (arr[i+2]%2==1){
                    return true;
                }else {
                    i+=2;
                }
            }else if (arr[i]%2==1){
                return false;//wrong
            }
        }
        return false;//wrong
    }

    public static void main(String[] args) {

    }
}
