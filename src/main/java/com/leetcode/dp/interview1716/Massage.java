package com.leetcode.dp.interview1716;

public class Massage {


    /**
     * dp[i]:
     * <p>
     * dp[i]=max{dp[i-2]+nums[i],dp[i-1]}
     * dp[0]=nums[0]
     * dp[1]=nums[1]
     */
//    public int massage(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        } else if (nums.length == 1) {
//            return nums[0];
//        }else if (nums.length==2){
//            return Math.max(nums[0],nums[1]);
//        }
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = nums[1];
//        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
//        }
//        return dp[nums.length - 1];
//    }
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Massage().massage(new int[]{2, 1, 1, 2}));
    }
}
