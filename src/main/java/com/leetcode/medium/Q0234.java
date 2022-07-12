package com.leetcode.medium;

import com.leetcode.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

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
public class Q0234 {
    public boolean isPalindrome(ListNode head) {
        final Deque<Integer> stack = new ArrayDeque<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        final ListNode mid = slow;
        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }
        for (ListNode node = head; node != mid; node = node.next) {
            final int val = stack.pop();
            if (node.val != val) return false;
        }
        return stack.isEmpty() || stack.size() == 1;
    }

    public Boolean isPalindrome1(ListNode head) {
        ListNode fast = head;
        ListNode newHead = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            final ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }

        if (fast != null) head = head.next;

        while (newHead != null && head != null) {
            if (newHead.val != head.val) return false;
            newHead = newHead.next;
            head = head.next;
        }

        return true;
    }
}
