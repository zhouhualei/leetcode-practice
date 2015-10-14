package me.warren.leetcode

import spock.lang.Specification

/**
 * Created by warzhou1 on 10/13/15.
 */
class Solution141Test extends Specification {
    def "HasCycleTrue"() {
        setup:
            def head = new ListNode(0);
            def node1 = new ListNode(1);
            def node2 = new ListNode(2);
            def node3 = new ListNode(3);
            def node4 = new ListNode(4);
            def s = new Solution141();
        when:
            head.next = node1;
            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
            node4.next = node2;
        then:
            true == s.hasCycle(head)
    }

    def "HasCycleFalse"() {
        setup:
            def head = new ListNode(0);
            def node1 = new ListNode(1);
            def node2 = new ListNode(2);
            def node3 = new ListNode(3);
            def node4 = new ListNode(4);
            def s = new Solution141();
        when:
            head.next = node1;
            node1.next = node2;
            node2.next = node3;
            node3.next = node4;
        then:
            false == s.hasCycle(head)
    }
}
