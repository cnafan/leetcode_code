package com.leetcode.array.console1389;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArray {
    public static void main(String[] args) {
        int[] res=new CreateTargetArray().createTargetArray(new int[]{0,1,2,3,4},new int[]{0,1,2,2,1});
        for (int re : res) {
            System.out.println(re);
        }

    }
    public int[] createTargetArray(int[] nums, int[] index) {

        List<Integer>list=new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            list.add(index[i],nums[i]);
        }
        int[] res=new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}
