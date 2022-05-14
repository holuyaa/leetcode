package com.leetcode.medium;

import com.leetcode.Nodes;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0098Test {

    private static final Integer[][] TESTCASES = new Integer[][]{
            {2, 1, 3},
            {5, 1, 4, null, null, 3, 6},
            {5, 4, 6, null, null, 3, 7},
            {2147483647},
            {2, 2, 2},
    };

    private static final boolean[] EXPECTED = new boolean[]{
            true,
            false,
            false,
            true,
            false,
    };

    @Test
    void isValidBST() {
        final Q0098 q = new Q0098();
        for (int i = 0; i < TESTCASES.length; i++) {
            final boolean actual = q.isValidBST(Nodes.treeOf(TESTCASES[i]));
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}