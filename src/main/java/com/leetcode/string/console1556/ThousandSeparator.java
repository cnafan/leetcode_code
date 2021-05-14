package com.leetcode.string.console1556;

public class ThousandSeparator {
    public String thousandSeparator(int n) {
        if(n==0){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        int index=0;
        while (n!=0){
            if (index%3==0&&index!=0){
                sb.append(".");
                index=0;
            }
            sb.append(n%10);
            index++;
            n/=10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ThousandSeparator().thousandSeparator(123456896));
    }
}
