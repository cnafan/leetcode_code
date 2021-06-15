package com.leetcode.binary.offer53;

public class Search {

    /**
     * 两次二分找到左右边界，求差值
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = findFirst(nums, 0, nums.length - 1, target);
        if (nums.length < 1 || left == -1) {
            return 0;
        }
        int right = findLast(nums, left, nums.length - 1, target);
        return right - left + 1;
    }


    int findFirst(int[] nums, int left, int right, int target) {
        if (right < left) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            if (mid == 0 || nums[mid - 1] != target) {
                return mid;
            } else {
                return findFirst(nums, left, mid - 1, target);
            }
        }
        if (nums[mid] > target) {
            return findFirst(nums, left, mid - 1, target);
        } else {
            return findFirst(nums, mid + 1, right, target);
        }
    }

    int findLast(int[] nums, int left, int right, int target) {
        if (right < left) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            if (mid == nums.length - 1 || nums[mid + 1] != target) {
                return mid;
            } else {
                return findLast(nums, mid + 1, right, target);
            }
        }
        if (nums[mid] > target) {
            return findLast(nums, left, mid - 1, target);
        } else {
            return findLast(nums, mid + 1, right, target);
        }
    }
    //
    // 非排除
    // 取不到右边界
//    int binary2(int[] nums, int left, int right, int target) {
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target) {
//                count++;
//                if (mid + 1 < right && nums[mid] == nums[mid + 1]) {
//                    left = mid + 1;
//                } else if (mid - 1 >= left && nums[mid] == nums[mid - 1]) {
//                    right = mid;
//                } else {
//                    break;
//                }
//            } else if (nums[mid] < target) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) {
        System.out.println(new Search().search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
