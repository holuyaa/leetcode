package com.leetcode.medium;

import com.leetcode.ListNode;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Q0148 {
    public ListNode sortList(ListNode head) {
        int count = 0;
        for (ListNode node = head; node != null; node = node.next) count++;

        final int[] numbers = new int[count];
        count = 0;
        for (ListNode node = head; node != null; node = node.next) numbers[count++] = node.val;

        Arrays.sort(numbers);
        count = 0;
        for (ListNode node = head; node != null; node = node.next) node.val = numbers[count++];

        return head;
    }

    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;

        final ListNode mid = getMid(head);
        final ListNode left = sortList1(head);
        final ListNode right = sortList1(mid);
        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode prev = null;
        while (head != null && head.next != null) {
            prev = (prev == null) ? head : prev.next;
            head = head.next.next;
        }
        ListNode mid = prev.next;
        prev.next = null;
        return mid;
    }

    private ListNode merge(ListNode left, ListNode right) {
        final ListNode dummyHead = new ListNode();
        ListNode next = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                next.next = left;
                left = left.next;
            } else {
                next.next = right;
                right = right.next;
            }
            next = next.next;
        }
        next.next = (left != null) ? left : right;
        return dummyHead.next;
    }
}
