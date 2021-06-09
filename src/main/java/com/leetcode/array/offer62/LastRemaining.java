package com.leetcode.array.offer62;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫环
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-j30k/
 */
public class LastRemaining {
    public int lastRemaining(int n, int m) {
        if (m == 1) {
            return n - 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {

            index = (index + m - 1) % (list.size());
            list.remove(index);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new LastRemaining().lastRemaining(5, 3));
    }
}
