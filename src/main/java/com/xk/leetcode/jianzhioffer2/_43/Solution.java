package com.xk.leetcode.jianzhioffer2._43;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countDigitOne(999, 0));
    }

    int[] dp = new int[]{1, 2, 21, 301, 4001, 50001, 600001, 7000001, 80000001, 900000001};
    List<Integer> digit = new ArrayList<>();
    List<Integer> bit = new ArrayList<>();

    public int countDigitOne(int n, int i) {

        //20 * 10  + 100

        //456 20 * 4 + 100      56  1 * 5 + 10     6    1       180 + 15 + 1 = 196
        //(dp[i] - 1) * (n / 10) + digit

        if (n / 10 == 0) return 1;

        int a = countDigitOne(Integer.parseInt((n + "").substring(1)), i);
        digit.set(i, digit.get(i) * 10);
        if (n / digit.get(i) == 1) {
            int b = countDigitOne(Integer.parseInt((n + "").substring(1)), i + 1);
            bit.set(i, bit.get(i) + 1);
            return (dp[bit.get(i) - 1] - 1) * (n / digit.get(i)) + n % 10 + b + a;
        }
        bit.set(i, bit.get(i) + 1);
        return (dp[bit.get(i)] - 1) * (n / digit.get(i)) + digit.get(i) + a;
    }
}
