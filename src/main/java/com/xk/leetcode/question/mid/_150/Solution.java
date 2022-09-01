package com.xk.leetcode.question.mid._150;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String str = tokens[i];
            if (isNum(str)) {
                s.push(Integer.parseInt(str));
            } else {
                int a = s.pop();
                int b = s.pop();
                if ("+".equals(str)) {
                    s.push(b + a);
                } else if ("-".equals(str)) {
                    s.push(b - a);
                } else if ("*".equals(str)) {
                    s.push(b * a);
                } else {
                    s.push(b / a);
                }
            }
        }
        return s.pop();
    }

    boolean isNum(String s) {
        return !("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s));
    }
}
