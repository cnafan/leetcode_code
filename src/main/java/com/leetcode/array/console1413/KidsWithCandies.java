package com.leetcode.array.console1413;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy= candies[0];
        List<Boolean> iscandies=new ArrayList<>(candies.length);
        for (int candy : candies) {
            if (candy > maxCandy) {
                maxCandy = candy;
            }
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i]+extraCandies>=maxCandy){
                iscandies.add(i,true);
            }else {
                iscandies.add(i,false);
            }
        }
        return iscandies;
    }

    public static void main(String[] args) {
        for (Boolean kidsWithCandy : new KidsWithCandies().kidsWithCandies(new int[]{12,1,12}, 10)) {
            System.out.println(kidsWithCandy);
        }
    }
}
