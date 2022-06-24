package com.xk.leetcode.competition._297._2304;

class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;

        int n = brackets.length;
        int tmp = 0;
        for (int[] bracket : brackets) {
            if (income > bracket[0]) {
                res += (bracket[0] - tmp) * (bracket[1] / 100d);
            } else {
                res += (income - tmp) * (bracket[1] / 100d);
                break;
            }
            tmp = bracket[0];
        }

        return res;
    }
}