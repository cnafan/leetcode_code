package com.offer.offer05;

/**
 * 从后向前复制
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        int len_k = 0;
        // 统计空格
        for (char c : s.toCharArray()) {
            if (' ' == c) {
                len_k++;
            }
        }
        int len = s.length() + 2 * len_k;
        char[] res = new char[len];
        int index = len - 1;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                res[index--] = '0';
                res[index--] = '2';
                res[index--] = '%';
            } else {
                res[index--] = s.charAt(i);
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceSpace().replaceSpace("ds ff fsw"));
    }
}
