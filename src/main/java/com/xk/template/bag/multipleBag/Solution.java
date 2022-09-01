package com.xk.template.bag.multipleBag;

public class Solution {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int[] itemNum = {1, 1, 1};
        int bagSize = 4;
        multipleBag(weight, value, itemNum, bagSize);
    }

    public static void multipleBag(int[] weight, int[] value, int[] itemNum, int bagSize) {
        int k = 0;
        int[] tempWeight = new int[10001];
        int[] tempValue = new int[10001];
        for (int i = 0; i < weight.length; i++) {
            for (int j = 1; j <= itemNum[i]; j <<= 1) {
                k++;
                tempWeight[k] = weight[i] * j;
                tempValue[k] = value[i] * j;
                itemNum[i] -= j;
            }
            if (itemNum[i] != 0) {
                k++;
                tempWeight[k] = weight[i] * itemNum[i];
                tempValue[k] = value[i] * itemNum[i];
            }
        }
//        oneDp_ZeroOneBag(tempWeight, tempValue, bagSize, k);
        twoDp_ZeroOneBag(tempWeight, tempValue, bagSize, k);
    }

    public static void twoDp_ZeroOneBag(int[] weight, int[] value, int bagSize, int itemNum) {
        int value0 = 0;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[itemNum + 1][bagSize + 1];
        //初始化：背包容量为0时，能获得的价值都为0
        for (int i = 0; i <= itemNum; i++) {
            dp[i][0] = value0;
        }
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 1; i <= itemNum; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i <= itemNum; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void oneDp_ZeroOneBag(int[] weight, int[] value, int bagWeight, int itemNum) {
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < itemNum; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++) {
            System.out.print(dp[j] + " ");
        }
    }

}
