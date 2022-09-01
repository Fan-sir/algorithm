package com.xk.bishi.songqingyang.bishi03.xiaohongshu._2;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), m = s.nextInt(), id = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += s.nextInt();
            }
            arr[i] = sum;
        }

        int res = 0;
        int deng = 0;
        id--;
        for (int i = 0; i < n; i++) {
            if (arr[id] < arr[i]) res++;
            if (i < id && arr[id] == arr[i]) deng++;
        }
        System.out.println(res + deng + 1);

    }

}
