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
}
