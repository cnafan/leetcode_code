package com.leetcode.tree.console14;

import com.sun.jndi.ldap.Ber;
import com.sun.org.apache.bcel.internal.generic.LNEG;

public class LongestCommonPrefix {
    /**
     * 纵向对比
     * 每次对比同一列
     *
     * @param strs
     * @return
     */

    public String longestCommonPrefix2(String[] strs) {
        int strLen = strs[0].length();
        int count = strs.length;
        for (int i = 1; i < strLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < count; j++) {
                if (c != strs[j].charAt(i) || i == strs[j].length())
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    /**
     * 横向对比，一次对比两个字符串
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() < 1) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0,index);
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
    }
}
