package com.leetcode.array.console1313;

import java.util.ArrayList;
import java.util.List;

public class DecompressRLElist {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < nums[i]; j++) {
                    list.add(nums[i + 1]);
                }
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (Integer integer : list) {
            res[index++] = integer;
        }
        return res;
    }

    public static void main(String[] args) {
        int []res=new DecompressRLElist().decompressRLElist(new int[]{1,1,2,3});
        for (int re : res) {
            System.out.println(re);
        }

    }
}
