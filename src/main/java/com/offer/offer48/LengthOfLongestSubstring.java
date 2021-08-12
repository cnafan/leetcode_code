package com.offer.offer48;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 滑动窗口，
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0;
        // 用于存放最长字符串的字符位置
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 如果出现重复的字符，计算平移到下一个位置，开始平移窗口，
                // 选择两者大的原因是：abba，如果不比较，可能会导致回退
                left = Math.max(left, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("saflskdafj"));
    }
}
