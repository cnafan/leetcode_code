package com.leetcode.math.console136;

/**
 * 异或运算，对应位相异时得 1，相同时得 0，那么某个数跟本身异或时，因为对应位都相同所以结果为 0 ， 然后异或又满足交换律和结合律
 * https://leetcode-cn.com/problems/single-number/solution/dong-hua-dong-tu-yi-ding-hui-by-yuan-chu-vs4p/
 *
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int single=0;
        for (int num:nums){
            single^=num;
        }
        return single;
    }

}
