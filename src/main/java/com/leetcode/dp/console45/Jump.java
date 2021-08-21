package com.leetcode.dp.console45;

import java.util.Arrays;


public class Jump {
    /**
     * 双指针 +dp+贪心
     * dp[i]:到达i位置所需最少步数
     * dp[i]=dp[j]+1; j:距离i最远的位置
     *
     * 时间复杂度：O(n)
     */
    public int jump(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1, j = 0; i < nums.length; i++) {
            // 找到符合一步跳到i的位置j
            while (j + nums[j] < i){
                j++;
            }
            dp[i]=dp[j]+1;
        }
        return dp[nums.length-1];
    }

    /**
     * 贪心：从最后一个往前走，每次选择最前方的那个点
     */
    public int jump2(int[] nums) {
        int pos = nums.length - 1;
        int step = 0;
        while (pos > 0) {
            for (int i = 0; i < pos; i++) {
                if (i + nums[i] >= pos) {
                    pos = i;
                    step++;
                    break;
                }
            }
        }

        return step;
    }

    /**
     * https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
     * 贪心（正向）
     * @param nums
     * @return
     */
    public int jump3(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        System.out.println(new Jump().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
