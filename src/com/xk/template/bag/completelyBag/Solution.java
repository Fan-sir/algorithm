package com.xk.template.bag.completelyBag;

public class Solution {

    public static void main(String[] args) {
        completelyBag1();
    }

    //先遍历物品，再遍历背包
    private static void completelyBag1() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) { // 遍历物品
            for (int j = weight[i]; j <= bagWeight; j++) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int maxValue : dp) {
            System.out.print(maxValue + " ");
        }
    }

    //先遍历背包，再遍历物品
    private static void completelyBag2() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 1; i <= bagWeight; i++) { // 遍历背包容量
            for (int j = 0; j < weight.length; j++) { // 遍历物品
                if (i - weight[j] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }
        for (int maxValue : dp) {
            System.out.print(maxValue + " ");
        }
    }

}
