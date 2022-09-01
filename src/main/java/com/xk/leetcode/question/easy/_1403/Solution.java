package com.xk.leetcode.question.easy._1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int sumT = 0;
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            sumT += nums[i];
            res.add(nums[i]);
            if (sumT > (sum >> 1)) return res;
        }
        return res;
    }
}