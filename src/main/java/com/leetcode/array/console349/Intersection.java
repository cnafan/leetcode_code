package com.leetcode.array.console349;

import java.util.*;

/**
 * 哈希set
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for (Integer num:nums1){
            set1.add(num);
        }
        for (int j : nums2) {
            if (set1.contains(j)) {
                set2.add(j);
            }
        }
        int index=0;
        int[] res=new int[set2.size()];
        for (Integer num:set2) {
            res[index++]=num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Intersection().intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
