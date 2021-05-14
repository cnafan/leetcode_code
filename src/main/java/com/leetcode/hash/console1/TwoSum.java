package com.leetcode.hash.console1;

import javax.swing.*;
import java.util.*;

/**
 * 两数之和:寻找两数之和等于目标值，转换为i==target-nums[i]
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length;++i) {
            if (map.containsKey(target-nums[i])){
                return  new int[]{i,map.get(target- nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
