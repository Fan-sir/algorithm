package com.xk.leetcode.jianzhioffer2._29;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().spiralOrder(new int[][] {
                {1,2,3,4}
        })));
    }

    int[] res;
    int index = 0;

    public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        res = new int[n * m];
        traverse(matrix, 0, 0, n, m);
        return res;
    }

    void traverse(int[][] matrix, int i, int j, int n, int m) {
        int tmpI = i, tmpJ = j;
        int num = 2 * (m + n) - 4;
        if (n <= 0 || m <= 0) {
            System.out.println("");
            return;
        }
        if (index == matrix.length * matrix[0].length - 1) {
            res[index] = matrix[i][j];
            return;
        }
        int[][] d = new int[][]{
                {0, 1},//右
                {1, 0},//下
                {0, -1},//左
                {-1, 0} //上
        };

        int flag = 0;
        for (int k = 0; k < num; k++) {
            res[index++] = matrix[i][j];
            i += d[flag][0];
            j += d[flag][1];
            if (i - tmpI >= n || i - tmpI < 0 || j - tmpJ >= m || j - tmpJ < 0) {
                if (index == matrix.length * matrix[0].length) return;
                i -= d[flag][0];
                j -= d[flag][1];
                flag++;
                //1 2 3 4
                //5 6 7 8
                //9 10 11 12

                //6 7

                // 2*(n+m)-4
                if (flag == 4) flag = 0;
                i += d[flag][0];
                j += d[flag][1];
            }
        }

        traverse(matrix, i + 1, j + 1, n - 2, m - 2);
    }
}
