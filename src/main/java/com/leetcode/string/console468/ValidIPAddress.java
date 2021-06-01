package com.leetcode.string.console468;

/**
 * String[] strings = IP.split("\\.");
 * Java中正则需要\\表示转义
 */
public class ValidIPAddress {
    /**
     * 流的处理
     * https://leetcode-cn.com/problems/validate-ip-address/solution/yan-zheng-ip-di-zhi-by-leetcode/
     * @param IP
     * @return
     */
    public String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validIPv4(IP);
        }
        else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validIPv6(IP);
        }
        else return "Neither";
    }


//    public String validIPAddress(String IP) {
//        if (IP.contains(".")){
//           return validIPv4(IP);
//        }
//        else if (IP.contains(":")){
//            return validIPv6(IP);
//        }
//        else
//            return "Neither";
//    }


    public String validIPv4(String IP) {
        String[] strings = IP.split("\\.",-1);
        for (String string : strings) {
            if (string.length() == 0 || string.length() > 3) {
                return "Neither";
            }
            if (string.charAt(0)=='0'&& string.length()!=1){
                return "Neither";
            }
            for (char ch:string.toCharArray()){
                if (!Character.isDigit(ch)){
                    return "Neither";
                }
            }
            if (Integer.parseInt(string) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }
    public String validIPv6(String IP){
        // 当limit<0，表示分割尽可能多
        String[] strings=IP.split(":",-1);
        String hexdigits = "0123456789abcdefABCDEF";
        for (String x:strings){
            if (x.length() == 0 || x.length() > 4) {
                return "Neither";
            }
            for (char ch:x.toCharArray()){
                if (hexdigits.indexOf(ch) == -1) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

    public static void main(String[] args) {
        System.out.println(new ValidIPAddress().validIPAddress("1.1.1.1."));
    }
}
