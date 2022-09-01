package com.xk.leetcode.jianzhioffer2._57_I;

import java.util.HashSet;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            if (!set.contains(num)) set.add(target - num);
            else return new int[]{num, target - num};
        return new int[]{};
    }
}
