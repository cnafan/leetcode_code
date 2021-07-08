package com.offer.offer38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 回溯
 * 2. 递归
 */
public class Permutation {
    // 递归
//    public String[] permutation2(String s) {
//
//    }

    // 回溯
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        boolean[] visit = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backtrace(res,chars, new StringBuilder(), visit);
        return res.toArray(new String[0]);
    }

    void backtrace(List<String> res, char[] chars, StringBuilder tmp, boolean[] visit) {
        if (tmp.length() == chars.length) {
            res.add(new String(tmp));
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // 未访问
            if (visit[i]) {
                continue;
            }
            // 剪枝，即重复出现上一个的字符的字符直接跳过，因此需要排序，把相同的字符挨在一起
            if (i > 0 && chars[i] == chars[i - 1] && visit[i - 1]) continue; // 剪枝

            visit[i] = true;
            tmp.append(chars[i]);
            backtrace(res, chars, tmp, visit);
            visit[i] = false;
            tmp.deleteCharAt(tmp.length() - 1);

        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Permutation().permutation("evv")));

    }
}
