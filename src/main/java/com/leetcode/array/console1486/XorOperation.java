package com.leetcode.array.console1486;

public class XorOperation {
    public static void main(String[] args) {

        System.out.println(new XorOperation().xorOperation(5, 0));
    }
    public int xorOperation(int n, int start) {
        int res=start;
        for (int i=1;i<n;i++)
        {
           res^=start+2*i;
        }
        return res;
    }
}
