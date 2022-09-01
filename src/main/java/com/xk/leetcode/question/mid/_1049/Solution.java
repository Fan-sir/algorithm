package com.xk.leetcode.question.mid._1049;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;

        int sum = 0;
        for(int i : stones) {
            sum += i;
        }
        int target = sum >> 1;
        int[] dp = new int[target + 1];

        for(int i = 0; i < n; i++) {
            for(int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - 2 * dp[target];
    }
}