package com.offer.offer15;

/**
 * 逐位判断
 * 与运算 &1=0，最后一位为0；&1=1，最后一位为1
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int res=0;
        while (n!=0){
            res+=n&1;
            n>>>=1;
        }
        return res;
    }
}
