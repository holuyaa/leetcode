package com.leetcode.medium;

import com.leetcode.Nodes;
import com.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0102Test {
    private static final Integer[][] TESTCASES = new Integer[][]{
            {3, 9, 20, null, null, 15, 7},
            {1},
            {},
    };

    private static final List<List<List<Integer>>> EXPECTED = List.of(
            List.of(List.of(3), List.of(9, 20), List.of(15, 7)),
            List.of(List.of(1)),
            Collections.emptyList()
    );

    @Test
    void levelOrder() {
        final Q0102 q = new Q0102();
        levelOrder(q::levelOrder);
    }

    @Test
    void levelOrder1() {
        final Q0102 q = new Q0102();
        levelOrder(q::levelOrder1);
    }

    private void levelOrder(Function<TreeNode, List<List<Integer>>> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final List<List<Integer>> actual = func.apply(Nodes.treeOf(TESTCASES[i]));
            System.out.println(actual);
            assertThat(actual, is(EXPECTED.get(i)));
        }
    }
}