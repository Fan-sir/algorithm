package com.xk.leetcode.jianzhioffer2._49;

import java.util.HashMap;

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int a = 1, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            int two = dp[a] * 2, three = dp[b] * 3, five = dp[c] * 5;
            dp[i] = Math.min(Math.min(three, five), two);
            if (two == dp[i]) a++;
            if (three == dp[i]) b++;
            if (five == dp[i]) c++;
        }
        return dp[n];
    }
}