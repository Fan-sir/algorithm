package com.xk.sort.bubbleSort;

public class Solution {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 15, 5, 8, 2, 4, 11, 4, 10};
        new Solution().bubbleSort(arr);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

}