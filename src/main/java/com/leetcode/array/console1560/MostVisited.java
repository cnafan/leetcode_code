package com.leetcode.array.console1560;

import java.util.ArrayList;
import java.util.List;

public class MostVisited {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] hash=new int[n+1];
        for (int i = 1; i < rounds.length; i++) {
            int round=0;
            if (rounds[i]<rounds[i-1]){
                round++;
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {

    }
}
