package com.xk.leetcode.question.easy._1413;

class Solution {
    public int minStartValue(int[] nums) {
        int a = nums[0] >= 0 ? 1 : -nums[0] + 1;
        int res = a;
        int n = nums.length;
        for (int num : nums) {
            a += num;
            if (a < 1) {
                res += (1 - a);
                a = 1;
            }
        }
        return res;
    }
}
