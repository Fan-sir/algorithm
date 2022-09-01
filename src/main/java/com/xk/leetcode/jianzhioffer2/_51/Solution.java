package com.xk.leetcode.jianzhioffer2._51;

class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = nums[i];
        }
        int[] tmp = new int[n];

        return reverse(copy, 0, n - 1, tmp);
    }

    int reverse(int[] copy, int left, int right, int[] tmp) {
        if (left == right) return 0;

        int mid = left + ((right - left) >> 1);
        int leftNum = reverse(copy, left, mid, tmp);
        int rightNum = reverse(copy, mid + 1, right, tmp);

        if (copy[mid] <= copy[mid + 1]) {
            return leftNum + rightNum;
        }

        int merger = merger(copy, left, mid, right, tmp);
        return leftNum + rightNum + merger;
    }

    int merger(int[] copy, int left, int mid, int right, int[] tmp) {
        for (int i = left; i <= right; i++) {
            tmp[i] = copy[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                copy[k] = tmp[j];
                j++;
            } else if (j == right + 1) {
                copy[k] = tmp[i];
                i++;
            } else if (tmp[i] <= tmp[j]) {
                copy[k] = tmp[i];
                i++;
            } else {
                copy[k] = tmp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}