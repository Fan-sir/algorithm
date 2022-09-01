package com.xk.leetcode.jianzhioffer2._31;

import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int index = 0;
        for (int num : pushed) {
            s.push(num);
            while (!s.isEmpty() && s.peek() == popped[index]) {
                s.pop();
                index++;
            }
        }
        return s.isEmpty();
    }
}