package com.xk.leetcode.jianzhioffer2._46;

class Solution {
    int res = 0;

    public int translateNum(int num) {
        String a = num + "";
        back(a, a.length(), new StringBuffer());
        return res;
    }

    void back(String num, int length, StringBuffer sb) {
        if (sb.length() == length) {
            res++;
            return;
        }

        for (int i = 0; i < 2 && i < num.length(); i++) {
            String s = num.substring(0, i + 1);
            int tmp = Integer.parseInt(s);
            if (tmp > 25 || (s.length() == 2 && s.charAt(0) == '0')) {
                continue;
            }
            sb.append((char) (tmp + 97));
            back(num.substring(i + 1), length, new StringBuffer(sb));
        }

    }
}