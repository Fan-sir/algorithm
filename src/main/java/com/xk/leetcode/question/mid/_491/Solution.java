package com.xk.leetcode.question.mid._491;

import java.util.*;


//class Solution {
//
//    public static void main(String[] args) {
//        System.out.println(new Solution().findSubsequences(new int[]{4, 6, 7, 7}));
//    }
//
//    Set<List<Integer>> res = new HashSet<>();
//    List<Integer> level = new ArrayList<>();
//
//    public List<List<Integer>> findSubsequences(int[] nums) {
//        back(nums, 0);
//        return new ArrayList<>(res);
//    }
//
//    //   4    6     7       7
//    //46 47  67    77
//    //467 477  677
//    //4677
//    void back(int[] arr, int start) {
//        int a = level.size() - 1;
//        if (start == arr.length || (a > 0 && level.get(a - 1) > level.get(a))) {
//            return;
//        }
//
//        for (int i = start; i < arr.length; i++) {
//            level.add(arr[i]);
//            int m = level.size() - 1;
//            if (m > 0 && level.get(m - 1) <= level.get(m)) {
//                res.add(new ArrayList<>(level));
//            }
//
//            back(arr, i + 1);
//            level.remove(level.size() - 1);
//        }
//    }
//}
class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findSubsequences(new int[]{1, 2, 3, 1}));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {

        Set<List<Integer>> listAll = new HashSet<>();
        dfs(listAll, nums, new ArrayList<>(), 0);
        return new ArrayList<>(listAll);

    }

    public void dfs(Set<List<Integer>> listAll, int[] nums, List<Integer> list, int start) {

        for (int i = start; i < nums.length; i++) {
            if (list.isEmpty()) {
                list.add(nums[i]);
            } else {
                if (list.get(list.size() - 1) <= nums[i]) {
                    list.add(nums[i]);
                    listAll.add(new ArrayList<>(list));
                }
            }

            dfs(listAll, nums, list, i + 1);
            if (list.size() - 1 >= 0) {
                list.remove(list.size() - 1);
            }
        }
    }
}