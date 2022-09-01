package com.xk.leetcode.competition._300._2325;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        int n = key.length();
        byte[] flag = new byte[26];
        Arrays.fill(flag, (byte)0);
        int index = 0;
        for(int i = 0; i < n; i++) {
            char c = key.charAt(i);
            if(c == ' ') {
                continue;
            }
            if(flag[c - 97] == 0) {
                flag[c - 97] = 1;
                map.put(c, (char)('a' + index++));
            }
        }
        System.out.println(map);
        n = message.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(message.charAt(i) == ' ') {
                sb.append(" ");
            } else {
                sb.append(map.get(message.charAt(i)));
            }
        }
        return sb.toString();
    }
}