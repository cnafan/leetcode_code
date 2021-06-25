package com.leetcode_twice.slidewindow.console3;

import java.util.HashMap;

/**
 * 滑动窗口
 * 即每次检测新的字符有没有存在于一个不含重复元素的连续字串中，如果存在，则向后滑动一次窗口，若不存在，则将该元素添加到子串中，并更新最大长度
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i))) + 1;
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("asbcas"));
    }
}
