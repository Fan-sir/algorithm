package com.xk.leetcode.competition._300._2326;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int row = 0, col = 0;
        int[][] arr = new int[m][n];
        while(head != null) {
            for(int i = 0; i < n; i++) {
                if(head == null) break;
                arr[row][i] = head.val;
                head = head.next;
            }
            row++;
            for(int i = 0; i < m; i++) {
                if(head == null) break;
                arr[i][n - 1] = head.val;
                head = head.next;
            }
            n--;

            for(int i = 0; i < n; i++) {
                if(head == null) break;
                arr[m - 1][i] = head.val;
                head = head.next;
            }
            m--;
            for(int i = 0; i < m; i++) {
                if(head == null) break;
                arr[i][col] = head.val;
                head = head.next;
            }

            col++;
        }
        return arr;
    }
}