package com.xk.leetcode.jianzhioffer2._44;

class Solution {
    long[] dp = new long[]{9, 180, 2700, 36000, 450000, 5400000, 63000000, 720000000, 8100000000L};

    public int findNthDigit(int n) {
        if (n < 10) return n;
        int length = dp.length;
        long sum = 0;
        //180 / 9   2       +1   pow(10,2)  +   20 / 3 = 6     100 + 6 + 1          0
        for (int i = 1; i < length; i++) {
            sum += dp[i - 1];
            if (sum <= n && sum + dp[i] > n) {
                int bit = Integer.parseInt(((sum / 9) + "").substring(0, 1));
                int bitNum = (int) Math.pow(10, bit);
                int yu = (int) ((n - sum - 1) % (bit + 1));
                // System.out.println(sum);
                // System.out.println(bitNum);
                // System.out.println(yu);
                // System.out.println(bit);
                bitNum += ((n - sum - 1) / (bit + 1));
                // System.out.println(bitNum);
                return Integer.parseInt((bitNum + "").substring(yu, yu + 1));
            }
        }
        return 0;
    }
}
