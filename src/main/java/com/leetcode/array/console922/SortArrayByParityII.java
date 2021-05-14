package com.leetcode.array.console922;

import com.leetcode.array.console905.SortArrayByParity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        List<Integer> A1=new ArrayList<>();
        List<Integer> A2=new ArrayList<>();
        for (int x = 0; x < A.length; x+=2) {
            if (A[x]%2==1){
                A1.add(x);
            }
        }
        for (int x = 1; x < A.length; x+=2) {
            if (A[x]%2==0){
                A2.add(x);
            }
        }
        int index=0;
        for (int x = 0; x < A1.size(); x++) {
            int temp=A[A1.get(index)];
            A[A1.get(index)]=A[A2.get(index)];
            A[A2.get(index)]=temp;
            index++;
        }
        return A;
    }

    public int[] sortArrayByParityII2(int[] A) {
        int j=1;
        for (int x = 0; x < A.length; x+=2) {
            if (A[x]%2==1){
                while (A[j]%2==1){
                    j+=2;
                }
                int temp=A[x];
                A[x]=A[j];
                A[j]=temp;
            }
        }
        return A;
    }
    public int[] sortArrayByParityII3(int[] A) {
        for(int i = 0, j = 1; i < A.length && j < A.length; i += 2, j += 2) {
            while(i < A.length && A[i] % 2 == 0) i += 2;
            while(j < A.length && A[j] % 2 == 1) j += 2;
            if(i < A.length && j < A.length) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArrayByParityII().sortArrayByParityII2(new int[]{4, 2, 5, 7})));
    }
}
