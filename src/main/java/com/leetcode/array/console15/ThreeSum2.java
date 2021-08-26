package com.leetcode.array.console15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : cnafan
 * @date : 2021-08-25 22:24
 * <p>
 * 三数之和,优化三层for
 * 查找一个可以用hash存储
 * 查找两个元素可以用双指针
 *
 * 难点：去重（3处），即对a,b,c都要去重
 * - 对于每个元素去重
 * - 对于找到的每个左右指针也要去重
 **/
public class ThreeSum2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // 对于每个元素 也要进行去重 -1 -1 0 1
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            int target = -(nums[i]);
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 如果 -1，-1，0，1 已经找到-1，0，1 则应该向后找到一个不一样的数，不然会导致重复的三元组
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    //
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum2().threeSum(new int[]{-2,0,1,1,2}));
    }

}
