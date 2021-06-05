package com.leetcode.string.console125;

public class IsPalindrome {
    /**
     * 双指针
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && !(Character.isAlphabetic(s.charAt(start)) || Character.isDigit(s.charAt(start)))) {
                start++;
            }
            while (start < end && !(Character.isAlphabetic(s.charAt(end)) || Character.isDigit(s.charAt(end)))) {
                end--;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
//    public boolean isPalindrome(String s) {
//        if (s.length() == 0 || s.length() == 1) {
//            return true;
//        } else if (Character.toLowerCase(s.charAt(0)) != Character.toLowerCase(s.charAt(s.length() - 1))) {
//            return false;
//        }
//        return isPalindrome(s.substring(1, s.length() - 1));
//    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
