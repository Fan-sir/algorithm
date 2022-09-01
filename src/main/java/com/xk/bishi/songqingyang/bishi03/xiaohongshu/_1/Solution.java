package com.xk.bishi.songqingyang.bishi03.xiaohongshu._1;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long k = s.nextLong();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        Arrays.sort(arr);

        long res = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == j) continue;
                if (arr[i] * arr[j] >= k) res++;
                else break;
            }
        }
        System.out.println(res);
    }

}
