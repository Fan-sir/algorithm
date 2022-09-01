package com.xk.leetcode.jianzhioffer2._50;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Character, Integer> map = new HashMap<>();

    public char firstUniqChar(String s) {
        if (s.length() == 0) {
            return ' ';
        }
        char[] arr = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (char c : arr) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }
}
