package com.leetcode.easy;

import com.leetcode.ListNode;
import com.leetcode.Nodes;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0206Test {

    private static final int[][] TESTCASES = new int[][]{
            {1, 2, 3, 4, 5},
            {1, 2},
            {},
    };

    private static final int[][] EXPECTED = new int[][]{
            {5, 4, 3, 2, 1},
            {2, 1,},
            {},
    };

    @Test
    void reverseList() {
        final Q0206 q = new Q0206();
        for (int i = 0; i < TESTCASES.length; i++) {
            final ListNode tc = Nodes.listOf(TESTCASES[i]);
            final int[] actual = Nodes.toArray(q.reverseList(tc));
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}