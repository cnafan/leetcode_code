package com.leetcode.backtrack.console78;

import javax.xml.transform.Templates;
import java.util.ArrayList;
import java.util.List;

/**
 * 子集（不含重复元素） 回溯法 传递begin确保不重复
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtrace(nums,0, new ArrayList<>(),res);
        return res;
    }

    void backtrace(int[] nums, int begin, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for (int i = begin; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrace(nums,i+1,temp,res);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }
}
