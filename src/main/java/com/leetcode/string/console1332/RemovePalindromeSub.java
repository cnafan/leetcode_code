package com.leetcode.string.console1332;

public class RemovePalindromeSub {
    public int removePalindromeSub(String s) {
      if ("".equals(s))
        return 0;
      else if (isPalindrome(s)){
          return 1;
      }else {
          return 2;
      }
    }

    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while (i<j){
            if (s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new RemovePalindromeSub().removePalindromeSub("abb"));
    }
}
