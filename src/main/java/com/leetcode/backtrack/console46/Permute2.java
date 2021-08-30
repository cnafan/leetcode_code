package com.leetcode.backtrack.console46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : cnafan
 * @date : 2021-08-27 22:03
 **/
public class Permute2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int[] visited=new int[nums.length];
        backtrace(nums,0,res,new ArrayList<>(),visited);
        return res;
    }

    public void backtrace(int[] nums,int index, List<List<Integer>> res , List<Integer> temp,int[] visited){
        if(index==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[index]);
            backtrace(nums,index+1,res,temp,visited);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute2().permute(new int[]{1,2,3}));
    }
}
