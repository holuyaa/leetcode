package com.leetcode.medium;

import com.leetcode.ListNode;
import com.leetcode.Nodes;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0019Test {
    private static final int[][] TESTCASES = new int[][]{
            {1, 2, 3, 4, 5},
            {1},
            {1, 2},
            {1, 2},
    };

    private static final int[] N = new int[]{
            2,
            1,
            1,
            2,
    };

    private static final String[] EXPECTED = new String[]{
            "[1,2,3,5]",
            "[]",
            "[1]",
            "[2]"
    };

    @Test
    void removeNthFromEnd() {
        final Q0019 q = new Q0019();
        removeNthFromEnd(q::removeNthFromEnd);
    }

    @Test
    void removeNthFromEnd1() {
        final Q0019 q = new Q0019();
        removeNthFromEnd(q::removeNthFromEnd1);
    }

    private void removeNthFromEnd(BiFunction<ListNode, Integer, ListNode> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final ListNode head = Nodes.listOf(TESTCASES[i]);
            final ListNode node = func.apply(head, N[i]);
            final String actual = node != null ? node.toString() : "[]";
            System.out.println(actual);
            assertEquals(EXPECTED[i], actual);
        }
    }
}