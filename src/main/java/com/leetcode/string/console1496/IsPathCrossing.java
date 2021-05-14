package com.leetcode.string.console1496;

import java.util.HashSet;
import java.util.Set;

public class IsPathCrossing {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int nextX = 0, nextY = 0;
        set.add(nextX + "," + nextY);
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    nextY++;
                    break;
                case 'S':
                    nextY--;
                    break;
                case 'E':
                    nextX++;
                    break;
                case 'W':
                    nextX--;
                    break;
            }
            if (set.contains(nextX + "," + nextY)){
                return true;
            } else {
                set.add(nextX + "," + nextY);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsPathCrossing().isPathCrossing("NES"));
    }
}
