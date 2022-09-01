package com.xk.leetcode.jianzhioffer2._48;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int res = 0;
        for (int i = 0, j = 0; j < n; j++) {
            char c = s.charAt(j);
            while (set.contains(c)) {
                set.remove(s.charAt(i++));
            }
            set.add(c);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}