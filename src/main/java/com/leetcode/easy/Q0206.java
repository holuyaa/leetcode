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
}
