package com.leetcode.backtrack.console46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列 使用回溯
 * 状态变量:
 * 使用 visit[i]保存是否访问过。temp存放临时状态
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        int[] visited=new int[nums.length];
        backtrace(res,nums,new ArrayList<>(),visited);
        return res;
    }
    void backtrace(List<List<Integer>> res, int[] nums, ArrayList<Integer> temp, int[] visited){
        //
        if (temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]==1){
                continue;
            }
            visited[i]=1;
            temp.add(nums[i]);
            backtrace(res,nums,temp,visited);
            visited[i]=0;
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1,2,3}));
    }
}
