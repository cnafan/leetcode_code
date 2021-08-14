package com.offer.offer57_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 滑动窗口
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence3(int target) {
        int left = 1; // 滑动窗口的左边界
        int right = 2; // 滑动窗口的右边界
        int sum = left + right; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();
        //窗口的左边是窗口内的最小数字，只能小于等于target / 2,
        //因为题中要求的是至少含有两个数
        while (left <= target / 2) {
            if (sum < target) {
                //如果窗口内的值比较小，右边界继续向右移动，
                //来扩大窗口
                sum += ++right;
            } else if (sum > target) {
                //如果窗口内的值比较大，左边边界往右移动，
                //缩小窗口
                sum -= left++;
            } else {
                //如果窗口内的值正好等于target，就把窗口内的值记录
                //下来，然后窗口的左边和右边同时往右移一步
                int[] arr = new int[right - left + 1];
                for (int k = left; k <= right; k++) {
                    arr[k - left] = k;
                }
                res.add(arr);
                //左边和右边同时往右移一位
                sum -= left++;
                sum += ++right;
            }
        }
        //把结果转化为数组
        return res.toArray(new int[res.size()][]);
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        // 左右的内边界
        int left = 1, right = 2;
        int sum = left + right;
        while (left <= target / 2) {
            if (sum == target) {
                int[] arr = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    arr[i - left] = i;
                }
                res.add(arr);
                // 窗口右移（左边界右移）
                sum -= left;
                left++;
            } else if (sum < target) {
                // 如果和小于target，则扩大右边界（注意先后顺序）
                right++;
                sum += right;
            } else {
                // 否则，减少左边界（注意先后顺序）
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new FindContinuousSequence().findContinuousSequence(9)));
    }
}
