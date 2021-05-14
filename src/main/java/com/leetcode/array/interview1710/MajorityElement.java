package com.leetcode.array.interview1710;

import sun.awt.ModalExclude;

import java.time.temporal.Temporal;
import java.util.zip.CheckedOutputStream;

public class MajorityElement {
    public int majorityElement(int[] nums) {
//        int[] hash=new int[nums.length+1];
//        for (int num : nums) {
//            hash[num]++;
//        }
//        int max=hash[1];
//        int res=-1;
//        for (int i = 1; i < hash.length; i++) {
//            if (max<=hash[i]){
//                max=hash[i];
//                res=i;
//            }
//        }
//        return  max>(nums.length/2)?res:-1;
        int major=nums[0],count=1;
        for (int i = 1; i < nums.length; i++) {
            if (count==0){
                major=nums[i];
                count++;
            }else {
                if (nums[i] != major) {
                    count--;
                } else {
                    count++;
                }
            }
        }
        // 验证
        int len=nums.length/2+1;
        count=0;
        for (int num : nums) {
            if (num== major){
                count++;
            }
            if (count==len){
                return major;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{1}));
    }
}
