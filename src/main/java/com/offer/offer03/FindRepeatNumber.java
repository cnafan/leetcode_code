package com.offer.offer03;

/**
 * 1. 哈希 o(n)
 * 2. 排序 o(nlogn)
 * 3. 交换 o(n)
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 当遇到数字和编号不符合时，准备交换
            while (nums[i]!=i) {
                // 如果数字和需要交换的值一样时，即找到重复数字
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = i;
                nums[tmp] = tmp;
            }
        }
        return  -1;
    }
}
