package com.xk.leetcode.jianzhioffer2._56_II;

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;

        for (int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }

        return a;
    }
}
