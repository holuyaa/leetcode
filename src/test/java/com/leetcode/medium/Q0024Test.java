package com.leetcode.medium;

import com.leetcode.ListNode;
import com.leetcode.Nodes;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class Q0024Test {
    private static final int[][] TESTCASES = new int[][]{
            {1,2,3,4},
            {},
            {1},
    };

    private static final String[] EXPECTED = new String[]{
            "[2,1,4,3]",
            "[]",
            "[1]",
    };

    @Test
    void swapPairs() {
        final Q0024 q = new Q0024();
        swapPairs(q::swapPairs);
    }

    @Test
    void swapPairs1() {
        final Q0024 q = new Q0024();
        swapPairs(q::swapPairs1);
    }

    private void swapPairs(Function<ListNode, ListNode> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final ListNode head = Nodes.listOf(TESTCASES[i]);
            final ListNode node = func.apply(head);
            final String actual = node != null ? node.toString() : "[]";
            System.out.println(actual);
            assertEquals(EXPECTED[i], actual);
        }
    }
}