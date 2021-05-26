package com.leetcode.binary.console34;

import com.leetcode.binary.console33.Search;

import java.util.Arrays;

/**
 * 二分查找 左右扩展
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length<1){
            return new int[]{-1,-1};
        }
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target){
                int x=nums[mid];
                int pre=mid,next=mid;
                while (pre>0&&nums[pre-1]==nums[mid]){
                    pre--;
                }
                while (next<nums.length-1&&nums[next+1]==nums[mid]){
                    next++;
                }
                return new int[]{pre,next};
            }else if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{2,2}, 3)));
    }
}
