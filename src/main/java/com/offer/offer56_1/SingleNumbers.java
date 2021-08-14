package com.offer.offer56_1;

public class SingleNumbers {

    /**
     * 异或的特性：（位运算）相同为0，不同为1。（数字）p⊕q=q⊕p，p⊕0 = p，p⊕0=p
     * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shi-yao-zhe-ti-huan-ke-yi-yong-er-fen-cha-zhao-bi-/
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {

        int sum=0,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE,zero_count=0;
        for (int num:nums)  {
            // 统计0的个数
            if (num == 0) {
                zero_count+=1;
            }

            // 统计数组的最大最小值
            min=Math.min(min,num);
            max=Math.max(max,num);
            sum^=num;

        }
        // 特例：存在一个0
        if (zero_count == 1) {
            return new int[]{sum,0};
        }

        // 二分，找r,使得r满足{p}r{q}
        int left=min,right=max;
        while (left<=right){
            int mid=left+(right-left)/2;
            int leftSum=0,rightSum=0;
            for (int num:nums){
                if (num<mid){
                    leftSum^=num;
                }else {
                    rightSum^=num;
                }
            }
            // 如果两个都不为0,则分组成功
            if (leftSum != 0 && rightSum != 0) {
                return new int[]{leftSum,rightSum};
            } else if (leftSum == 0) {
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return null;

    }
}
