package com.leetcode.binary.console367;

/**
 * @author : cnafan
 * @date : 2021-11-04 20:11
 * 二分查找值，然后去判断
 */
public class IsPerfectSquare {
  public boolean isPerfectSquare(int num) {
    long left = 1, right = num / 2;
    while (left < right) {
      long mid = left + (right - left) / 2;
      long res = mid * mid;
      if (res == num) {
        return true;
      } else if (res < num) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left * left == num;
  }

  public static void main(String[] args) {
    //
    System.out.println(new IsPerfectSquare().isPerfectSquare(1));
  }
}
