package com.xk.leetcode.question.mid_416;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int n = nums.length;
        int target = sum >> 1;
        int[] dp = new int[target + 1];
        for (int i = 0; i < n; i++) {
            //这里nums[i]是优化过后的，因为背包重量和价值是一样的，在往前遍历也没有用了，
            //为了好理解，也可以将nums[i]改为0,改了0同时也需要判断，是否装不下
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return target == dp[target];
    }
}