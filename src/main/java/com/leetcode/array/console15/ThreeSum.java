package com.leetcode.array.console15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和：优化三重循环为一层循环+双指针
 *      左指针为i+1,右指针为n-1
 *
 * 若三者之和为0，即跳转下一个元素，同时移动左右指针
 *      否则，则移动左指针或右指针
 *
 * 首先要排序
 *
 * 特判：若num[i]>0则不可能为0
 *      若遇见重复元素则跳过
 *
 * 时间复杂度：O(n^2)
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            // 去重
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum== 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (left<right&&nums[left]==nums[left+1]) left++;
                    while (left<right&&nums[right]==nums[right-1]) right--;

                    left++;
                    right--;
                }
                else if (sum<0){
                    left++;
                }else {
                    right--;
                }

            }

        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ThreeSum().threeSum(new int[]{-3, -5, -9, -1 -2, 4, 5, 0, 8, 2, 1, 5, 6, 8, -7, -11});
        for (List<Integer> list:lists){
            System.out.println(list);
        }
    }
}
