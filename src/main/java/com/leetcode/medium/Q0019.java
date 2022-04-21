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
public class Q0019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        final ListNode[] nodes = new ListNode[31];
        nodes[0] = new ListNode(0, head);
        ListNode next = head;
        int i = 1;
        for (; next != null; i++, next = next.next) nodes[i] = next;
        next = nodes[i - n - 1];
        next.next = next.next.next;
        return nodes[0].next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        final ListNode headOfHead = new ListNode(0, head);

        ListNode shiftedNext = headOfHead;
        for (int i = 0; i <= n; i++) shiftedNext = shiftedNext.next;

        ListNode next = headOfHead;
        while (shiftedNext != null) {
            next = next.next;
            shiftedNext = shiftedNext.next;
        }

        next.next = next.next.next;
        return headOfHead.next;
    }
}
