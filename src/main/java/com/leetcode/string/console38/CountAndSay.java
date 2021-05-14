package com.leetcode.string.console38;

public class CountAndSay {
    public String countAndSay(int n) {
        String[] res=new String[n];
        res[0]="1";
        for (int i = 1; i <= n-1; i++) {
            res[i]=say(res[i-1]);
        }
        return res[n-1];
    }

    public String say(String n){
        StringBuilder stringBuilder=new StringBuilder();
        char temp=n.charAt(0);
        int count=1;
        for (int i = 1; i < n.length(); i++) {
            if (temp==n.charAt(i)){
                count++;
            }else {
                stringBuilder.append(count);
                stringBuilder.append(temp);
                count=1;
                temp=n.charAt(i);
            }
        }
        stringBuilder.append(count);
        stringBuilder.append(temp);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(5));
    }
}
