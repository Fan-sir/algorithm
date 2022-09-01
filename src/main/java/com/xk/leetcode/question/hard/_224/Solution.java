package com.xk.leetcode.question.hard._224;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 空白
 * @date 2022/6/16
 */
class Solution {
    public int calculate(String s) {
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        int n = s.length();
        int flag = 1;
        int res = 0;

        deque.push(1);

        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                flag = deque.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                flag = -deque.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                deque.push(flag);
                i++;
            } else if (s.charAt(i) == ')') {
                deque.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += flag * num;
            }
        }
        return res;
    }
}
