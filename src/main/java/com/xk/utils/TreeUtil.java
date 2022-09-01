package com.xk.utils;

import com.xk.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {

    /**
     * @param arr 前序数组
     * @return 树根
     */
    public static TreeNode buildTwoTree(Integer[] arr) {
        if (arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        TreeNode cur;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int j = 1;
        while (!queue.isEmpty() && j < arr.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (j < arr.length && arr[j] != null) {
                    cur.left = new TreeNode(arr[j]);
                    queue.offer(cur.left);
                }
                j++;
                if (j < arr.length && arr[j] != null) {
                    cur.right = new TreeNode(arr[j]);
                    queue.offer(cur.right);
                }
                j++;
            }
        }
        return root;
    }

}
