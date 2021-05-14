package com.leetcode.array.console1365;

public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] hash = new int[101];
        for (int num : nums) {
            hash[num]++;
        }
        int tmp = hash[0];
        hash[0]=0;
        for (int i = 1; i < hash.length; i++) {
            int local = hash[i];
            hash[i] = hash[i - 1] + tmp;
            tmp = local;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = hash[nums[i]];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new SmallerNumbersThanCurrent().smallerNumbersThanCurrent(new int[]{5,0,10,0,10,6});
        for (int re : res) {
            System.out.println(re);
        }

    }
}
