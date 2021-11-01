package com.leetcode.hash.console575;

/**
 * @author : cnafan
 * @date : 2021-11-01 17:34
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 糖果种类数大于等于糖果总量的一半，例如 candies = [1,1,2,3,4,5]、candies = [1,1,2,2,3,3]；
 * 糖果种类数小于糖果总量的一半，例如 candies = [1,1,1,1,1,2]。
 * 所以妹妹想要获得最大糖果的种类数，要么是总量的一半（case1），要么是糖果种类数（case2）
 * 即 min（n/2,m）
 */
public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int candy:candyType){
            map.put(candy,map.getOrDefault(candy,0)+1);
        }
        return Math.min(candyType.length/2,map.size());
    }

    public static void main(String[] args) {
        System.out.println(new DistributeCandies().distributeCandies(new int[]{1, 1, 2, 3}));
    }
}
