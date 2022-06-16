package com.leetcode.easy;

import com.leetcode.ListNode;

public class Q0206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        ListNode next = head.next;
        head.next = null;

        while (next != null) {
            final ListNode tmp = next.next;
            next.next = curr;
            curr = next;
            next = tmp;
        }
        return curr;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;

        final ListNode last = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }
}
