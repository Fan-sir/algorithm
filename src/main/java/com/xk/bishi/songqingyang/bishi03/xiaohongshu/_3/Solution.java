package com.xk.bishi.songqingyang.bishi03.xiaohongshu._3;

import com.xk.entity.TreeNode;
import com.xk.utils.TreeUtil;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        Integer[] arr = new Integer[n - 1];

        for (int i = 0; i < n - 1; i++) {
            arr[i] = s.nextInt();
        }

        TreeNode root = TreeUtil.buildTwoTree(arr);

        traverse(root.left);
        traverse(root.right);
        System.out.println(res);
    }
    static int res = 0;
    static void traverse(TreeNode root) {
        if (root == null) return;

        if (root.left != null && root.right != null) res++;
        traverse(root.left);
        System.out.println(root.val);
        traverse(root.right);
    }

}
