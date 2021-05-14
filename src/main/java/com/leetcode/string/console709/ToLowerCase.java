package com.leetcode.string.console709;

public class ToLowerCase {
    public static void main(String[] args) {
        System.out.println(new ToLowerCase().toLowerCase("HDdaH"));
    }
    public String toLowerCase(String str) {
        char[] strArray=str.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i]>='A'&&strArray[i]<='Z'){
                strArray[i]+=('a'-'A');
            }
        }
        return new String(strArray);
    }
}
