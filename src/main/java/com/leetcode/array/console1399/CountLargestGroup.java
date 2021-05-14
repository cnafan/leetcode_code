package com.leetcode.array.console1399;

public class CountLargestGroup {
    public static void main(String[] args) {
        System.out.println(new CountLargestGroup().countLargestGroup(15));

    }

    public int countLargestGroup(int n) {
        int[] hash = new int[37];
        // 计算每个数的数位和，并统计和一样的出现几次(组里有多少个）
        for (int i = 1; i <= n; i++) {
            hash[addEach(i)]++;
        }
        int max = hash[1];
        for (int i = 1; i <=36; i++) {
            if (hash[i] > max) {
                max = hash[i];
            }
        }
        int resNUM = 0;
        for (int i = 1; i <= 36; i++) {
            if (hash[i] == max) {
                resNUM++;
            }
        }
        return resNUM;

    }

    public int addEach(int num) {
        int res = num%10;
        while (num /10 != 0) {
            num /= 10;
            res += num % 10;
        }
        return res;
    }
}
