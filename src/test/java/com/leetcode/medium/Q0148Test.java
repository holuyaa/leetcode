package com.leetcode.medium;

import com.leetcode.ListNode;
import com.leetcode.Nodes;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

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
        sortList(q::sortList);
    }

    @Test
    void sortList1() {
        final Q0148 q = new Q0148();
        sortList(q::sortList1);
    }

    private void sortList(Function<ListNode, ListNode> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final ListNode actual = func.apply(Nodes.listOf(TESTCASES[i]));
            System.out.println(actual);
            assertListEqualsArray(actual, EXPECTED[i]);
        }
    }

    private void assertListEqualsArray(ListNode actual, int[] expect) {
        ListNode node = actual;
        for (int num : expect) {
            assertEquals(num, node.val);
            node = node.next;
        }
    }
}