package com.offer.offer50;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 采用linkedHashMap，可以以访问顺序进行遍历
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        Map<Character,Integer> map=new LinkedHashMap<>();
        for (char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c:map.keySet()){
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';

    }
}
