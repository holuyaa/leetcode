package com.leetcode.easy;

import com.leetcode.Nodes;
import com.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0094Test {

    private static final Integer[][] TESTCASES = new Integer[][]{
            {1, null, 2, null, null, 3},
            {},
            {1},
    };

    private static final int[][] EXPECTED = new int[][]{
            {1, 3, 2},
            {},
            {1},
    };

    @Test
    void inorderTraversal() {
        final Q0094 q = new Q0094();
        inorderTraversal(q::inorderTraversal);
    }

    @Test
    void inorderTraversal1() {
        final Q0094 q = new Q0094();
        inorderTraversal(q::inorderTraversal1);
    }

    private void inorderTraversal(Function<TreeNode, List<Integer>> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final List<Integer> actual = func.apply(Nodes.treeOf(TESTCASES[i]));
            System.out.println(actual);
            assertThat(actual.toArray(), is(EXPECTED[i]));
        }
    }
}