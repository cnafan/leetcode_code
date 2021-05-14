package com.leetcode.array.console1470;

import java.util.ArrayList;
import java.util.List;

public class Shuffle {
    public int[] shuffle(int[] nums, int n) {
        int[] numR = new int[nums.length];
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(nums[i]);
            array.add(nums[n + i]);
        }
        for (int i = 0; i < array.size(); i++) {
            numR[i] = array.get(i);
        }
        return numR;

    }

    public int[] shuffle2(int[] nums, int n) {
        int[] numR = new int[nums.length];
        int index = 0;
        for (int i = 0; i < n; i++) {
            numR[index++] = nums[i];
            numR[index++] = nums[n + i];
        }
        return numR;

    }

    public static void main(String[] args) {
        int[] a = new Shuffle().shuffle2(new int[]{1, 1, 2, 2}, 2);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
