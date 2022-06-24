package com.xk.leetcode.competition._297._2303;

import java.util.Arrays;

class Solution {

    //   0 1
    // 0 5 3
    // 1 4 0
    // 2 2 1

    //dp[i][j] = min dp[i - 1][k] + moveCost[dp[i - 1][k]][j] + grid[i][k];
    //dp[2][1] = min dp[1][1] + moveCost[dp[1][1]][1] + grid[2][1];

    //   0 1
    // 0 9 8
    // 1 1 5
    // 2 10 12
    // 3 18 6
    // 4 2 4
    // 5 14 3

    //这是一道典型的dp题目，相识题目有：https://leetcode.cn/problems/unique-paths/
    //
    //定义状态：dp[i][j]表示以grid[i][j]结尾的路径的的最小值
    //状态转移：dp[i][j] = Math.min(dp[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j],dp[i][j]);
    //dp[i - 1][k] 从dp[i-1][k]到dp[i][j]
    //moveCost[grid[i - 1][k]][j] 从dp[i-1][k]到dp[i][j]的路径的值
    //grid[i][j] 该点的值

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int res = Integer.MAX_VALUE;

        int row = grid.length;
        int col = grid[0].length;

        int[][] cost = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        System.arraycopy(grid[0], 0, cost[0], 0, col);

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < col; k++) {
                    cost[i][j] = Math.min(cost[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j], cost[i][j]);
                }
            }
        }
        row--;
        for (int i = 0; i < col; i++) {
            res = Math.min(res, cost[row][i]);
        }

        return res;
    }

}