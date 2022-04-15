package com.leetcode.medium;

import com.leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class com.leetcode.ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode result = new ListNode();
        ListNode next = result;
        int carry = 0;
        while (true) {
            final int tmp = l1.val + l2.val + carry;
            next.val = tmp % 10;
            carry = tmp / 10;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null || l2 == null) break;
            next.next = new ListNode();
            next = next.next;
        }

        l1 = l1 != null ? l1 : l2;
        while (l1 != null) {
            next.next = new ListNode();
            next = next.next;
            final int tmp = l1.val + carry;
            next.val = tmp % 10;
            carry = tmp / 10;
            l1 = l1.next;
        }

        if (carry > 0) next.next = new ListNode(carry);

        return result;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        int carry = 0;
        final ListNode result = new ListNode();
        ListNode next = result;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            next.next = new ListNode(carry % 10);
            next = next.next;
            carry = carry / 10;
        }

        if (carry > 0) next.next = new ListNode(carry);

        return result.next;
    }
}
