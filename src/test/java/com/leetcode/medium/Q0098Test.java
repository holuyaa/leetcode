package com.leetcode.medium;

import com.leetcode.Nodes;
import com.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0098Test {

    private static final Integer[][] TESTCASES = new Integer[][]{
            {2, 1, 3},
            {5, 1, 4, null, null, 3, 6},
            {5, 4, 6, null, null, 3, 7},
            {2147483647},
            {2, 2, 2},
            {1, 1},
            {-2147483648},
    };

    private static final boolean[] EXPECTED = new boolean[]{
            true,
            false,
            false,
            true,
            false,
            false,
            true,
    };

    @Test
    void isValidBST() {
        final Q0098 q = new Q0098();
        isValidBST(q::isValidBST);
    }

    @Test
    void isValidBST1() {
        final Q0098 q = new Q0098();
        isValidBST(q::isValidBST1);
    }

    @Test
    void isValidBST2() {
        final Q0098 q = new Q0098();
        isValidBST(q::isValidBST2);
    }

    private void isValidBST(Function<TreeNode, Boolean> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final boolean actual = func.apply(Nodes.treeOf(TESTCASES[i]));
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}