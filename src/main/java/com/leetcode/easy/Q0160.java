package com.leetcode.easy;

import com.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Q0160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        final Set<ListNode> set = new HashSet<>();
        for (ListNode node = headA; node != null; node = node.next) set.add(node);
        for (ListNode node = headB; node != null; node = node.next) {
            if (set.contains(node)) return node;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int count = 0;
        for (ListNode node = headA; node != null; node = node.next) count++;
        for (ListNode node = headB; node != null; node = node.next) count--;
        if (count < 0) return getIntersectionNode1(headB, headA, -count);
        return getIntersectionNode1(headA, headB, count);
    }

    private ListNode getIntersectionNode1(ListNode headA, ListNode headB, int count) {
        ListNode nodeA = headA;
        for (int i = 0; i < count; i++) nodeA = nodeA.next;

        ListNode nodeB = headB;
        while (nodeA != null) {
            if (nodeA == nodeB) return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
            if (nodeA == nodeB) break;
            if (nodeA == null) nodeA = headB;
            if (nodeB == null) nodeB = headA;
        }
        return nodeA;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            if (nodeA == null) nodeA = headB;
            else nodeA = nodeA.next;
            if (nodeB == null) nodeB = headA;
            else nodeB = nodeB.next;
        }
        return nodeA;
    }
}
