package com.xk.leetcode.jianzhioffer2._32_I;

import com.xk.entity.TreeNode;
import com.xk.utils.TreeUtil;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<Integer> list = new LinkedList<>();

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[]{};
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode a = q.pop();
                list.add(a.val);
                if (a.left != null) q.offer(a.left);
                if (a.right != null) q.offer(a.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

