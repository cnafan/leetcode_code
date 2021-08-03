package com.offer.offer39;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int num=nums[0],count=1;
        for (int i = 1; i < nums.length; i++) {
            if (count==0){
                num=nums[i];
                count=1;
            }else {
                if (nums[i]==num){
                    count++;
                }else {
                    count--;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{1, 1, 1, 1, 1, 3, 3, 2, 2, 2, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5}));
    }
}
