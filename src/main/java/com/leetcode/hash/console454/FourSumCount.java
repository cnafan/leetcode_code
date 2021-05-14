package com.leetcode.hash.console454;

import java.util.*;

/**
 * A+B+C+D=0 等价于 A+B=-(C+D)
 * 所以分两组 A+B求和o（n2） C+D求和
 * 如果C+D==A+B，统计A+B的个数即可
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int res = 0;
        // ab
        Map<Integer, Integer> hashAB = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if (hashAB.containsKey(sum)) {
                    hashAB.put(sum, hashAB.get(sum) + 1);
                } else {
                    hashAB.put(sum, 1);
                }
            }
        }

        //cd
        Map<Integer, Integer> hashCD = new HashMap<>();
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = -(nums3[i] + nums4[j]);
                if (hashCD.containsKey(sum)) {
                    res += hashCD.get(sum) + 1;
                }
            }
        }

        return res;
    }
    List<Integer> ab = new ArrayList<>();
    List<Integer> cd = new ArrayList<>();
    // 二分法
//    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//
//
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                ab.add(nums1[i] + nums2[j]);
//            }
//        }
//        for (int i = 0; i < nums3.length; i++) {
//            for (int j = 0; j < nums4.length; j++) {
//                cd.add(nums3[i] + nums4[j]);
//            }
//        }
//        Arrays.sort(new List[]{cd});
//
//        // 二分
//        int res=0;
//        for (int i = 0; i < ab.size(); i++) {
//           res+= binary(cd,ab.get(i) );
//        }
//        return res;
//    }
//    public int binary(List<Integer>num,int target){
//        int left=0,right=num.size()-1;
//        while (left<right){
//            int mid=left+(right-left)/2;
//            if (num.get(mid)<target){
//                left=mid+1;
//            }else {
//                right=mid;
//            }
//        }
//        if (num.get(left)!=target){
//            return -1;
//        }
//        return left;
//    }
}
