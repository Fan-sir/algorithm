package com.xk.sort.quickSort;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 15, 5, 8, 2, 4, 11, 4, 10};
        new Solution().quickSort(arr, 0, 8);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) return; //左数不小于右数，直接返回
        int pivot = arr[left]; //永远以最左边的数为基准
        int i = left, j = right;
        while (i < j) {
            while (arr[j] >= pivot && i < j) --j; //从右向左遇到小于基准的数就停止
            while (arr[i] <= pivot && i < j) ++i; //从左向右遇到大于基准的数就停止
            if (i < j) { //交换
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //基准数归位（位置已确定）
        arr[left] = arr[i];
        arr[i] = pivot;
        //分别对基准数两端的子数组进行快排
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

}