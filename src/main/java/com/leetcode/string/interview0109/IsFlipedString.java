package com.leetcode.string.interview0109;

public class IsFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length()!=s2.length()){
            return false;
        }
        return (s1 + s1).contains(s2);
    }

    public static void main(String[] args) {
        System.out.println(new IsFlipedString().isFlipedString("waterbottle", "erbottlewat"));
    }
}
