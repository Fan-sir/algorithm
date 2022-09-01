package com.xk.bishi.songqingyang.bishi02.wangyi._1;

import java.util.*;

public class Solution {
    Set<Integer> list1 = new HashSet<>();
    StringBuffer sb1 = new StringBuffer();

    Set<Integer> list2 = new HashSet<>();
    StringBuffer sb2 = new StringBuffer();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        
        String a = m + "";
        String b = n + "";

        int length = a.length() + b.length();

        //1234              99
        //1 9
        //1 99
        //2 9
        //2 99
        //3 9
        //3 99
        //4 9
        //4 99
        //12 9
        //12 99
        //13 9
        //13 99
        //14 9
        //14 99
        //23 9
        //23 99
        //24 9
        //24 99
        //34 9
        //34 99
        //123 9
        //123 99
        //124 9
        //124 99
        //234 9
        //234 99
        //1234 9
        //1234 99

        // 1                        2           3            4
        //12        13    14      23          34
        //123 124   134          234
        //1234
        Solution solution = new Solution();
        solution.back(a, 0, a.length());
        solution.back2(b, 0, b.length());
        ArrayList<Integer> arr1 = new ArrayList<>(solution.list1);
        ArrayList<Integer> arr2 = new ArrayList<>(solution.list2);
        System.out.println(arr1);
        System.out.println(arr2);
        int x = arr1.size();
        int y = arr2.size();
        int res = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (arr1.get(i) % arr2.get(j) == 0 || arr2.get(j) % arr1.get(i) == 0) {
//                    System.out.println(arr1.get(i) + "-" + arr2.get(j));
                    String tmp = arr1.get(i) + "" + arr2.get(j);
                    if (tmp.length() >= res) {
                        res = tmp.length();
                    }
                }
            }
        }
        System.out.println(length - res);
    }

    void back(String a, int start, int length) {
        if (sb1.length() != 0) list1.add(Integer.parseInt(sb1.toString()));

        for (int i = start; i < length; i++) {
            sb1.append(a.charAt(i));
            back(a, i + 1, length);
            sb1.deleteCharAt(sb1.length() - 1);
        }
    }

    void back2(String a, int start, int length) {
        if (sb2.length() != 0) list2.add(Integer.parseInt(sb2.toString()));

        for (int i = start; i < length; i++) {
            sb2.append(a.charAt(i));
            back2(a, i + 1, length);
            sb2.deleteCharAt(sb2.length() - 1);
        }
    }
}
