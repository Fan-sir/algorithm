package com.xk.sort.mergeSort;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().mergeSort(new int[]{5, 2, 5, 7, 2, 6, 7, 1})));
    }

    public int[] mergeSort(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums;
        }

        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = nums[i];
        }
        int[] tmp = new int[n];

        reverse(copy, 0, n - 1, tmp);
        return copy;
    }

    void reverse(int[] copy, int left, int right, int[] tmp) {
        if (left == right) return;

        int mid = left + ((right - left) >> 1);
        reverse(copy, left, mid, tmp);
        reverse(copy, mid + 1, right, tmp);

        merger(copy, left, mid, right, tmp);
    }

    void merger(int[] copy, int left, int mid, int right, int[] tmp) {
        for (int i = left; i <= right; i++) {
            tmp[i] = copy[i];
        }

        int i = left;
        int j = mid + 1;

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
            }
        }
    }
}