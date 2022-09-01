package com.xk.leetcode.jianzhioffer2._34;


import com.xk.entity.TreeNode;
import com.xk.utils.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> level = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        traverse(root, 0, target);
        return res;
    }

    void traverse(TreeNode root, int sum, int target) {
        if (root == null) return;
        level.add(root.val);
        sum += root.val;
        if (sum == target) {
            res.add(new ArrayList<>(level));
            level.remove(new Integer(root.val));
            return;
        }
        traverse(root.left, sum, target);
        traverse(root.right, sum, target);
        level.remove(level.size() - 1);
    }
}