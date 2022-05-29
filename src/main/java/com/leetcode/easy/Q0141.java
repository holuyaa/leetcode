package com.leetcode.easy;

import com.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Q0141 {
    public boolean hasCycle(ListNode head) {
        final Set<ListNode> set = new HashSet<>();
        for (ListNode node = head; node != null; node = node.next) {
            if (set.contains(node)) return true;
            set.add(node);
        }
        return false;
    }

    public Boolean hasCycle1(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) return true;
        }
        return false;
    }
}
