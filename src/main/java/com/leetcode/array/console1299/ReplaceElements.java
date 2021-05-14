package com.leetcode.array.console1299;

public class ReplaceElements {
    public int[] replaceElements(int[] arr) {
        int []maxindex=new int[arr.length];
        maxindex[maxindex.length - 1]=-1;
        int max=arr[maxindex.length - 1];
        for (int i = maxindex.length - 2; i >= 0; i--) {
            if (arr[i+1]>=max){
                max=arr[i+1];
            }
            maxindex[i]=max;
        }
        return maxindex;
    }

    public static void main(String[] args) {

       int[] res= new ReplaceElements().replaceElements(new int[]{17,18,5,4,6,1});
        for (int re : res) {
            System.out.println(re);
        }
    }
}
