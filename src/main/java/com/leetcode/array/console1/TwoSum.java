package com.leetcode.array.console1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : cnafan
 * @date : 2021-08-25 21:42
 **/
public class TwoSum {

    /**
     * 暴力
     */
    public int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j <  nums.length; j++) {
                if (nums[i]==target-nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }


    /**
     * 使用map优化查找从而降低O(n)
     */
    // key:值 value:下标
    Map<Integer,Integer> map=new HashMap<>();
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[2];
//        int n = nums.length;
//        //声明一个HashMap，key和value的类型都是int，变量名叫map。key和value分别记录数值和下标
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < n; i++){
//            //如果存在nums[j] + nums[i] == target，那么nums[j] = target - nums[i]
//            int diff = target - nums[i];
//            //如果存在diff，则返回diff和nums[i]的下标
//            //HashMap的containsKey方法判断该HashMap中是否存在这个key
//            if(map.containsKey(diff)){
//                //返回的时候直接创建一个数组，创建数组时可以直接初始化，就不需要填大小了，比如说new int[]{1, 2, 3};
//                //此时创建一个大小为2的数组，第一个元素为map.get(diff)也就是map中对应diff的value，第二个元素就是i，也就是2个数的下标
//                return new int[]{map.get(diff), i};
//            }else   //否则，将nums[i]存入map中
//                map.put(nums[i], i);
//        }
//        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{3, 3}, 7)));
    }
}
