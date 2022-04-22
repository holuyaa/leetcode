package com.leetcode.easy;

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
public class Q0021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        final ListNode head = list1.val < list2.val ? list1 : list2;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                while (list1.next != null && list1.next.val < list2.val) list1 = list1.next;
                final ListNode next = list1.next;
                list1.next = list2;
                list1 = next;
            } else {
                while (list2.next != null && list2.next.val <= list1.val) list2 = list2.next;
                final ListNode next = list2.next;
                list2.next = list1;
                list2 = next;
            }
        }
        return head;
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;


        final ListNode head = new ListNode(0);
        ListNode next = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                next.next = list1;
                list1 = list1.next;
            } else {
                next.next = list2;
                list2 = list2.next;
            }
            next = next.next;
        }
        if (list1 != null) next.next = list1;
        if (list2 != null) next.next = list2;
        return head.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }
}
