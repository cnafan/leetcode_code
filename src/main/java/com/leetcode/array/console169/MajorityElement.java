package com.leetcode.array.console169;

public class MajorityElement {
    /**
     * 摩尔计数法
     *
     * 时间复杂度:O(n)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int major=nums[0],count=1;
        for (int i = 1; i < nums.length; i++) {
            if (count==0){
                major=nums[i];
                count++;
            }else {
                if (major!=nums[i]){
                    count--;
                }else {
                    count++;
                }
            }
        }
        return major;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{3, 2, 3,2}));
    }
}
