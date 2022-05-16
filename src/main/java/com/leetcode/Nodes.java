package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Nodes {
    public static ListNode listOf(int[] array) {
        if (array == null || array.length == 0) return null;
        final ListNode root = new ListNode(array[0]);
        ListNode next = root;
        for (int i = 1; i < array.length; i++) {
            next.next = new ListNode(array[i]);
            next = next.next;
        }
        return root;
    }

    public static TreeNode treeOf(Integer[] array) {
        if (array == null || array.length == 0) return null;
        return createTree(array, 0);
    }

    private static TreeNode createTree(Integer[] array, int index) {
        if (array.length <= index || array[index] == null) return null;
        final TreeNode node = new TreeNode(array[index]);
        final int leftIndex = (index * 2) + 1;
        final int rightIndex = leftIndex + 1;
        node.left = createTree(array, leftIndex);
        node.right = createTree(array, rightIndex);
        return node;
    }

    public static Integer[] toArray(TreeNode root) {
        final int count = count(root, 0);
        final Integer[] result = new Integer[count / 2];
        toArray(root, result, 0);
        return result;
    }

    private static int count(TreeNode node, int pos) {
        if (node == null) return pos;
        final int left = count(node.left, (pos * 2) + 1);
        final int right = count(node.right, (pos + 1) * 2);
        return Math.max(left, right);
    }

    private static void toArray(TreeNode node, Integer[] result, int pos) {
        if (node == null) return;
        result[pos] = node.val;
        toArray(node.left, result, (pos * 2) + 1);
        toArray(node.right, result, (pos + 1) * 2);
    }
}
