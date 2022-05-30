package com.leetcode.medium;

import com.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Q0142 {
    public ListNode detectCycle(ListNode head) {
        final Set<ListNode> set = new HashSet<>();
        for (ListNode node = head; node != null; node = node.next) {
            if (set.contains(node)) return node;
            set.add(node);
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        boolean isCycle = false;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) return null;

        walker = head;
        while (walker != runner) {
            walker = walker.next;
            runner = runner.next;
        }

        return walker;
    }
}
