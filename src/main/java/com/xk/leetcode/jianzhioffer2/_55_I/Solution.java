package com.xk.leetcode.jianzhioffer2._55_I;

import com.xk.entity.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxLevel;

    public int maxDepth(TreeNode root) {
        traverse(root, 1);
        return maxLevel;
    }

    void traverse(TreeNode root, int level) {
        if (root == null) return;
        maxLevel = Math.max(maxLevel, level);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }
}
