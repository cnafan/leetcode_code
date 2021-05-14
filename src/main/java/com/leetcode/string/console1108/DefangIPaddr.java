package com.leetcode.string.console1108;

public class DefangIPaddr {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");

    }

    public static void main(String[] args) {
        System.out.println(new DefangIPaddr().defangIPaddr("255.100.50.0"));

    }
}
