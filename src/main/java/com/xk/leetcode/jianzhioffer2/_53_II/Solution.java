package com.xk.leetcode.jianzhioffer2._53_II;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1 - nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }
}
