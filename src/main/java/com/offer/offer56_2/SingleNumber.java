package com.offer.offer56_2;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/java-wei-yun-suan-qu-yu-wen-ti-jie-jue-b-gcbg/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int[] bit=new int[32];
        for (int num:nums){
            int curBit=1;
            for (int i = 31; i >=0; i--) {
                if ((curBit& num)!=0){
                    bit[i]++;
                }
                curBit<<=1;
            }
        }
        int res=0;
        for (int i = 0; i < 32; i++) {
            res<<=1;
            res+=bit[i]%3;
        }
        return res;
    }
}
