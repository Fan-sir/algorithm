package com.xk.leetcode.jianzhioffer2._54;

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
    int i = 0;
    int res = 0;
    int a = 0;

    public int kthLargest(TreeNode root, int k) {
        a = k;
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.right);
        i++;
        if (i == a) {
            res = root.val;
            return;
        }
        traverse(root.left);
    }
}
