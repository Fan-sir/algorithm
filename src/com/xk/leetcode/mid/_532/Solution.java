package com.xk.leetcode.mid._532;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author 空白
 * @date 2022/6/16
 */
public class Solution {
    public int findPairs(int[] nums, int k) {
        int res = 0;
        int n = nums.length;

        if (k == 0) {
            Arrays.sort(nums);
            int tmp = nums[0];
            boolean flag = true;
            for (int i = 1; i < n; i++) {
                if (nums[i] == tmp && flag) {
                    res++;
                    flag = false;
                } else if (nums[i] != tmp) {
                    flag = true;
                    tmp = nums[i];
                }
            }
            return res;
        }

        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        Iterator<Integer> iterator = set.iterator();
        nums = new int[n];
        for (int i = 0; iterator.hasNext(); i++) {
            nums[i] = iterator.next();
        }

        int i = 0, j = 1;
        while (i < n && j < n) {
            if (nums[j] - nums[i] == k) {
                res++;
                i++;
                j = i + 1;
                continue;
            }
            if (nums[j] - nums[i] > k) {
                i++;
                j = i + 1;
                continue;
            }
            j++;
        }

        return res;
    }
}
