package com.leetcode.math.console69;

public class MySqrt {
    /**
     * 二分查找的两种方式
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {

        // 特殊值判断
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int left = 1, right = x/2;
        while (left<right){
            int mid = left + (right - left+1) / 2;// ? +1 待定

            /**
             * 分析原因：在区间只有 22 个数的时候，根据 if、else 的逻辑区间的划分方式是：[left..mid - 1] 与 [mid..right]。如果 mid 下取整，在区间只有 22 个数的时候有 mid = left，一旦进入分支 [mid..right] 区间不会再缩小，发生死循环。
             *
             * 解决办法：把取中间数的方式改成上取整。
             *
             * 作者：liweiwei1419
             * 链接：https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
             * 来源：力扣（LeetCode）
             * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
             */

            if (mid>x/mid){
                right=mid-1;
            }else {
                left=mid;
            }

        }
        return left;
    }
    public int mySqrt2(int x) {
        int left = 0, right = x - 1,ans=-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * mid <= x) {
                ans=mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(4));
    }
}
