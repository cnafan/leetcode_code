package com.leetcode.array.console560;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和
 */
public class SubarraySum {
    /**
     * 暴力
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += nums[l];
                }
                if (sum == k) {
                    count++;

                }
            }
        }
        return count;
    }

    /**
     * 去除重复计算
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;

    }

    /**
     * 前缀和
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum3(int[] nums, int k) {
        int count = 0;
        // map用于统计（当前前缀和-k） 出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        //？
        // 遍历 nums 之前，我们让 -1 情况下的前缀和为 0，这样通式在边界情况也成立。即在遍历之前，map 初始放入 0:1 键值对。
        map.put(0,1);


        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 存储前缀和
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }

            // 若出现sum-k，累加
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraySum().subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(new SubarraySum().subarraySum2(new int[]{1, 1, 1}, 2));
        System.out.println(new SubarraySum().subarraySum3(new int[]{1, 1, 1}, 2));
    }
}
