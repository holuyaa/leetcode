package com.leetcode.medium;

import com.leetcode.ListNode;
import com.leetcode.Nodes;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0234Test {

    private static final int[][] TESTCASES = new int[][]{
            {1, 2, 2, 1},
            {1, 2},
            {1, 2, 3, 2, 1},
            {1, 2, 3, 3, 1},
    };

    private static final boolean[] EXPECTED = new boolean[]{
            true,
            false,
            true,
            false,
    };

    @Test
    void isPalindrome() {
        final Q0234 q = new Q0234();
        isPalindrome(q::isPalindrome);
    }

    @Test
    void isPalindrome1() {
        final Q0234 q = new Q0234();
        isPalindrome(q::isPalindrome1);
    }

    private void isPalindrome(Function<ListNode, Boolean> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final boolean actual = func.apply(Nodes.listOf(TESTCASES[i]));
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}