package com.leetcode.medium;

import com.leetcode.ListNode;
import com.leetcode.Nodes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0148Test {

    private static final int[][] TESTCASES = new int[][]{
            {4, 2, 1, 3},
            {-1, 5, 3, 4, 0},
            {},
    };

    private static final int[][] EXPECTED = new int[][]{
            {1, 2, 3, 4},
            {-1, 0, 3, 4, 5},
            {},
    };

    @Test
    void sortList() {
        final Q0148 q = new Q0148();
        for (int i = 0; i < TESTCASES.length; i++) {
            final ListNode actual = q.sortList(Nodes.listOf(TESTCASES[i]));
            System.out.println(actual);
            ListNode node = actual;
            for (int j = 0; j < EXPECTED[i].length; j++) {
                assertEquals(EXPECTED[i][j], node.val);
                node = node.next;
            }
        }
    }
}