package com.xk.leetcode.question.mid._93;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        back(s, 0, 0);
        System.out.println(res);
        return res;
    }

    void back(String s, int level, int start) {
        if (level == 3) {
            if (isValid(s, start, s.length() - 1)) {
                res.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isValid(s, start, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                back(s, ++level, i + 2);
                level--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else {
                break;
            }
        }
    }

    boolean isValid(String s, int start, int end) {
        if (start > end) return false;
        if (s.charAt(start) == '0' && start != end) return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) return false;
        }
        return true;
    }
}