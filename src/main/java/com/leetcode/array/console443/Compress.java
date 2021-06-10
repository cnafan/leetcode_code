package com.leetcode.array.console443;

public class Compress {
    /**
     * https://leetcode-cn.com/problems/string-compression/solution/ya-suo-zi-fu-chuan-by-leetcode/
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        if (chars.length < 2) {
            return chars.length;
        }
        // anchro 存储当前字符
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            // 最后一位或者遇到新字符时,先写入新字符
            if (read == chars.length - 1 || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c : ((read - anchor + 1) + "").toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        System.out.println(new Compress().compress(new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'}));
    }
}
