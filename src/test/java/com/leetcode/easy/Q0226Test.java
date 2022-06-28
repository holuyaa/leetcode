package com.leetcode.easy;

import com.leetcode.Nodes;
import com.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0226Test {

    private static final Integer[][] TESTCASES = new Integer[][]{
            {4, 2, 7, 1, 3, 6, 9},
            {2, 1, 3},
            {},
    };

    private static final Integer[][] EXPECTED = new Integer[][]{
            {4, 7, 2, 9, 6, 3, 1},
            {2, 3, 1},
            {},
    };

    @Test
    void invertTree() {
        final Q0226 q = new Q0226();
        invertTree(q::invertTree);
    }

    @Test
    void invertTree1() {
        final Q0226 q = new Q0226();
        invertTree(q::invertTree1);
    }

    private void invertTree(Function<TreeNode, TreeNode> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final Integer[] actual = Nodes.toArray(func.apply(Nodes.treeOf(TESTCASES[i])));
            System.out.println(Arrays.toString(actual));
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}