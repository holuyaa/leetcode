package com.leetcode.medium;

import com.leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q0024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        return swapPairs(head, head.next);
    }

    private ListNode swapPairs(ListNode left, ListNode right) {
        if (right == null) return left;

        left.next = right.next != null ? swapPairs(right.next, right.next.next) : null;
        right.next = left;
        return right;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null) return null;
        final ListNode result = new ListNode(0, head);
        ListNode next = result, left, right;

        while (next.next != null && next.next.next != null) {
            left = next.next;
            right = left.next;
            next.next = right;
            left.next = right.next;
            right.next = left;
            next = left;
        }
        return result.next;
    }
}
