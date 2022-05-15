package com.leetcode.easy;

import com.leetcode.Nodes;
import com.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0101Test {

    private static final Integer[][] TESTCASES = new Integer[][]{
            {1,2,2,3,4,4,3},
            {1,2,2,null,3,null,3},
    };

    private static final boolean[] EXPECTED = new boolean[]{
            true,
            false,
    };

    @Test
    void isSymmetric() {
        final Q0101 q = new Q0101();
        isSymmetric(q::isSymmetric);
    }

    @Test
    void isSymmetric1() {
        final Q0101 q = new Q0101();
        isSymmetric(q::isSymmetric1);
    }

    private void isSymmetric(Function<TreeNode, Boolean> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final boolean actual = func.apply(Nodes.treeOf(TESTCASES[i]));
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}