package me.warren.leetcode;

/**
 * Created by warzhou1 on 10/13/15.
 */


public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode oneStep = head;
        ListNode twoStep = head;

        do {
            if (oneStep == null || oneStep.next == null || twoStep == null || twoStep.next == null || twoStep.next.next == null) return false;
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        } while(oneStep != twoStep);
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        Solution141 s = new Solution141();
        System.out.println(s.hasCycle(head));
    }
}
