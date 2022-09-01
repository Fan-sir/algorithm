package com.xk.leetcode.jianzhioffer2._37;

import com.xk.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    StringBuffer sb = new StringBuffer();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        level(root);
        return sb.toString();
    }

    void level(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode a = q.poll();
                if (a == null) {
                    sb.append("null").append(",");
                } else {
                    sb.append(a.val).append(",");
                    q.offer(a.left);
                    q.offer(a.right);
                }
            }
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        data = data.substring(0, data.length() - 1);
        String[] strArr = data.split(",");
        Integer[] arr = new Integer[strArr.length];
        int i = 0;
        for (String s : strArr) {
            if ("null".equals(s)) {
                arr[i++] = null;
            } else {
                arr[i++] = Integer.parseInt(s);
            }
        }
        return buildTree(arr);
    }

    TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0) return null;
        Deque<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        q.offer(root);
        int j = 1;
        int n = arr.length;
        while (!q.isEmpty() && j < n) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (j < n && arr[j] != null) {
                    node.left = new TreeNode(arr[j]);
                    q.offer(node.left);
                }
                j++;
                if (j < n && arr[j] != null) {
                    node.right = new TreeNode(arr[j]);
                    q.offer(node.right);
                }
                j++;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
