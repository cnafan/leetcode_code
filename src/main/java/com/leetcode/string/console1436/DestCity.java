package com.leetcode.string.console1436;

import java.util.ArrayList;
import java.util.List;

public class DestCity {
    public static void main(String[] args) {

    }

    public String destCity(List<List<String>> paths) {
//       return paths.get(paths.size()-1).get(1);
        List<String> list = new ArrayList<>();
        for (List<String> path : paths) {
            if (!list.contains(path.get(0))) {
                list.add(path.get(0));
            }
        }
        for (List<String> path : paths) {
            if (list.contains(path.get(1))) {
                list.remove(path.get(1));
            }
        }
        return list.get(1);
    }
}
