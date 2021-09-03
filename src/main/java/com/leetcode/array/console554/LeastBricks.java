package com.leetcode.array.console554;

import java.util.*;

/**
 * 统计穿过砖最少的，即穿过缝最多的，即缝出现次数最多的；那么采用hash即可
 *
 * @author : cnafan
 * @date : 2021-08-30 19:06
 **/
public class LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> integers : wall) {
            int sum = 0;
            //j < integers.size() - 1 不统计右侧边缘
            for (int j = 0; j < integers.size() - 1; j++) {
                Integer w = integers.get(j);
                sum += w;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for (int each : map.keySet()) {
            res = Math.max(res, map.get(each));
        }
        return wall.size()-res;
    }
}
