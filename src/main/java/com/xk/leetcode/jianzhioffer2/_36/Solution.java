package com.xk.leetcode.jianzhioffer2._36;

import com.xk.entity.Node;

class Solution {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        traverse(root);
        head.left = pre;
        pre.right = head;

        return head;
    }

    void traverse(Node root) {
        if (root == null) return;
        traverse(root.left);

        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        root.left = pre;
        pre = root;

        traverse(root.right);
    }
}
