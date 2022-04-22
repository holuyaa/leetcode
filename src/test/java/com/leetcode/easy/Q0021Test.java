package com.leetcode.easy;

import com.leetcode.ListNode;
import com.leetcode.Nodes;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0021Test {

    private static final int[][] TESTCASES = new int[][]{
            {1, 2, 4},
            {1, 3, 4},
            {},
            {},
            {},
            {0},
            {-10, -10, -9, -4, 1, 6, 6},
            {-7},
            {-2, 5},
            {-9, -6, -3, -1, 1, 6},
    };

    private static final String[] EXPECTED = new String[]{
            "[1,1,2,3,4,4]",
            "[]",
            "[0]",
            "[-10,-10,-9,-7,-4,1,6,6]",
            "[-9,-6,-3,-2,-1,1,5,6]",
    };

    @Test
    void mergeTwoLists() {
        final Q0021 q = new Q0021();
        mergeTwoLists(q::mergeTwoLists);
    }

    @Test
    void mergeTwoLists1() {
        final Q0021 q = new Q0021();
        mergeTwoLists(q::mergeTwoLists1);
    }

    @Test
    void mergeTwoLists2() {
        final Q0021 q = new Q0021();
        mergeTwoLists(q::mergeTwoLists2);
    }

    private void mergeTwoLists(BiFunction<ListNode, ListNode, ListNode> func) {
        for (int i = 0; i < TESTCASES.length; i += 2) {
            final ListNode node = func.apply(Nodes.listOf(TESTCASES[i]), Nodes.listOf(TESTCASES[i + 1]));
            final String actual = node != null ? node.toString() : "[]";
            System.out.println(actual);
            assertEquals(EXPECTED[i >> 1], actual);
        }
    }
}