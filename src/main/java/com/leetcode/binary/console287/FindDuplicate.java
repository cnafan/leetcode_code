package com.leetcode.binary.console287;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    /**
     * 二分法
     * 时间复杂度：O(logn)
     */
    public int findDuplicate4(int[] nums) {
        int left=0,right= nums.length-1;
        while (left < right) {
            int mid=left+(right-left)/2;

            // 统计cnt(对于每个i不超过i的个数)
            int cnt=0;
            for(int num:nums){
                if (num<=mid){
                    cnt++;
                }
            }

            // 如果不超过4的数有5个，那么重复元素一定在左边
            // 排除
            if (cnt > mid) {
                right=mid;
            }
            else {
                left=mid+1;
            }
        }
        return left;
    }
    /**
     * 哈希表判重
     * 时间复杂度：O(1)
     */
    public int findDuplicate3(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (Integer num:nums){
            if (set.contains(num)){
                return num;
            }else {
                set.add(num);
            }
        }
        return -1;
    }




    /**
     * 先排序，找挨个
     * 时间复杂度O(nlogn)
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            int slow = nums[i];
            int fast = nums[i + 1];
            if (slow == fast) {
                return slow;
            }
        }
        return -1;
    }

    /**
     * 快慢指针
     * 时间复杂度：O(n)
     * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/kuai-man-zhi-zhen-de-jie-shi-cong-damien_undoxie-d/
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow=0,fast=0;
        slow=nums[slow];
        fast=nums[nums[fast]];
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        fast=0;
        while (slow != fast) {
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicate().findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new FindDuplicate().findDuplicate2(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new FindDuplicate().findDuplicate3(new int[]{1, 3, 4, 2, 2}));
        System.out.println(new FindDuplicate().findDuplicate4(new int[]{1, 3, 4, 2, 2}));
    }
}
