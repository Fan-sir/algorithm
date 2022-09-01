import java.util.*;

//package com.xk.leetcode.question._1408;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//class Solution {
//    public List<String> stringMatching(String[] words) {
//        Set<String> list = new HashSet<>();
//        int n = words.length;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i != j && words[i].contains(words[j])) {
//                    list.add(words[j]);
//                }
//            }
//        }
//        return new ArrayList<>(list);
//    }
//
//    public static void main(String[] args) {
//
//    }
//
//}
//class Solution {
//    TreeMap<Integer, Integer> res = new TreeMap<>();
//
//    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
//        int m = items1.length, n = items2.length;
//        if (m >= n) {
//            for (int i = 0; i < m; i++) {
//                boolean flag = false;
//                for (int j = 0; j < n; j++) {
//                    if (items1[i][0] == items2[j][0]) {
//                        flag = true;
//                        res.put(items1[i][0], items1[i][1] + items2[j][1]);
//                    }
//                }
//                if (!flag) {
//                    res.put(items1[i][0], items1[i][1]);
//                }
//            }
//        } else {
//            for (int i = 0; i < n; i++) {
//                boolean flag = false;
//                for (int j = 0; j < m; j++) {
//                    if (items2[i][0] == items1[j][0]) {
//                        flag = true;
//                        res.put(items2[i][0], items2[i][1] + items1[j][1]);
//                    }
//                }
//                if (!flag) {
//                    res.put(items2[i][0], items2[i][1]);
//                }
//            }
//        }
//        List<List<Integer>> list = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> entry : res.entrySet()) {
//            List<Integer> level = new ArrayList<>();
//            level.add(entry.getKey());
//            level.add(entry.getValue());
//            list.add(level);
//        }
//
//        return list;
//    }
//}