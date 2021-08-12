package com.offer.offer53_2;

/**
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/jian-zhi-offer-53-er-fen-cha-zhao-by-old-51n2/
 *
 *
 * 二分题目求特定值的左边界
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int left=0,right=nums.length-1;

        // 查找不存在的元素时，跳出条件为 left<=right
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]>mid){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        // 跳出时right在left左侧，
        return right;
    }
}
