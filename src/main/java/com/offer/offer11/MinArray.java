package com.offer.offer11;

public class MinArray {
    public int minArray(int[] numbers) {

        // 取到&排除
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid=left+(right-left)/2;


            // 不能用mid和left比较，例如[3, 4, 5, 1, 2] 与 [1, 2, 3, 4, 5] ，此时，中间位置的值都比左边大，但最小值一个在后面，一个在前面，因此这种做法不能有效地减治。
            if (numbers[mid]>numbers[right]){
                left=mid+1;
            }else if (numbers[mid]<numbers[right]){
                right=mid;
            }else {
                // https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-by-leetcode-s/
                right=right-1;
            }
        }
        return numbers[left];
    }
}
