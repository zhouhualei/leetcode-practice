package me.warren.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null;
        ListNode cur = null;
        ListNode next = null;
        ListNode last = null;


        int index = 1;
        cur = head;
        while (cur != null) {

            next = cur.next;

            if (index == m) {
                last = pre;
            } else if (index > m && index < n) {
                cur.next = pre;
            } else if (index == n) {
                cur.next = pre;
                if (last == null) {
                    head.next = next;
                    head = cur;
                } else {
                    last.next.next = next;
                    last.next = cur;
                }
            }

            index++;
            pre = cur;
            cur = next;
        }

        return head;
    }

    public static void main(String[] args) {
        int m = 1;
        int n = 2;

        int k = 1;
        ListNode head = null;
        ListNode cur = null;
        ListNode pre = null;
        while (k < 3) {
            pre = cur;
            cur = new ListNode(k);
            if (pre != null) {
                pre.next = cur;
            }
            if (k == 1) {
                head = cur;
            }
            k++;
        }
        cur.next = null;

        Solution92 solution = new Solution92();
        head = solution.reverseBetween(head, m, n);
        cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            System.out.print(' ');
            cur = cur.next;
        }
        System.out.println();
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
