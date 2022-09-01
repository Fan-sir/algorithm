package com.xk.bishi.songqingyang.bishi01._1;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().OneCount(10));
    }

    int OneCount(int n) {
        String s = Integer.toBinaryString(n);
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

}
