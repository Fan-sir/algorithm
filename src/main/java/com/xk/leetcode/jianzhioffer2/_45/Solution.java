package com.xk.leetcode.jianzhioffer2._45;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String minNumber(int[] nums) {
        return IntStream.of(nums).boxed().sorted((o1, o2) -> ((int) (Long.parseLong(o1 + String.valueOf(o2)) - Long.parseLong(o2 + String.valueOf(o1))))).map(String::valueOf).collect(Collectors.joining());
    }
}