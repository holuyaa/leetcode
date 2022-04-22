package com.leetcode;

public class Nodes {
    public static ListNode listOf(int[] array) {
        if (array == null || array.length == 0) return null;
        final ListNode root = new ListNode(array[0]);
        ListNode next = root;
        for (int i = 1; i < array.length; i++) {
            next.next = new ListNode(array[i]);
            next = next.next;
        }
        return root;
    }
}
