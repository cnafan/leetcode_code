package com.leetcode.backtrack.console93;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrace(s, 0, new ArrayList<>(), res);
        return res;
    }

    void backtrace(String s, int startIndex, List<String> temp, List<String> res) {
        if (temp.size() > 4) {
            return;
        }
        if (temp.size() >= 4 && startIndex != s.length()) {
            return;
        }

        if (temp.size() == 4) {
            res.add(String.join(".", temp));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            temp.add(substring);
            if (substring.length() > 1 && substring.startsWith("0") || substring.length() > 3) {
                continue;
            }
            int value = Integer.parseInt(substring);
            if (value < 0 || value > 255) {
                continue;
            }
            temp.add(substring);
            backtrace(s, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}
