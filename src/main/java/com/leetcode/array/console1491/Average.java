package com.leetcode.array.console1491;

public class Average {
    public static void main(String[] args) {
        System.out.println(new Average().average(new int[]{4000, 3000,3000}));
    }
    public double average(int[] salary) {
        int min=salary[0],max=salary[0],sum=0;
        for (int i : salary) {
            if (i>max){
                max=i;
            }else if (i<min){
                min=i;
            }
            sum+=i;
        }
        sum-=min;
        sum-=max;
        return (double)sum/(salary.length-2);
    }

}
