package com.leetcode.backtrack.console40;

import com.leetcode.backtrack.console39.CombinationSum;

import java.util.*;

/**
 * 回溯
 * 和39的区别在于多了去重，也就是每次循环不是从0开始，而是从上一次的位置继续向后循环
 *
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temp=new ArrayList<>();
        Arrays.sort(candidates);
        int[] could=new int[candidates.length];
        Arrays.fill(could,0);
        Set<List<Integer>> set=new HashSet<>();
        backtrace(candidates,target,set,temp,could,0,candidates.length);
        return new ArrayList<>(set);
    }
    void backtrace(int[] candidates,int target,Set<List<Integer>> set,List<Integer> temp,int[] could,int begin,int end){
        if (target<0){
            return;
        }
        if (target==0){
            set.add(new ArrayList<>(temp));
            return;
        }

        for (int i = begin ; i < end; i++) {
            if (could[i] == 1) {
                continue;
            }
            if (target-candidates[i]<0){
                continue;
            }
            temp.add(candidates[i]);
            could[i]=1;
                backtrace(candidates, target - candidates[i], set, temp, could, i + 1, end);
            temp.remove(temp.size()-1);
            could[i]=0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
