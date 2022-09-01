package com.xk.leetcode.jianzhioffer2._56_I;

class Solution {
    public int[] singleNumbers(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int a : nums) sum ^= a;

        int flag = sum & (-sum);

        int res = 0;
        for (int a : nums) {
            if ((flag & a) != 0) {
                res ^= a;
            }
        }

        return new int[]{res, sum ^ res};
    }

}
