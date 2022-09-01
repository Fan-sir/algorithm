package com.xk.leetcode.jianzhioffer2._53_I;

class Solution {
    public int search(int[] nums, int target) {
        int res = 0;
        int n = nums.length;
        for (int num : nums) {
            if (num == target) res++;
        }
        return res;
    }
}
