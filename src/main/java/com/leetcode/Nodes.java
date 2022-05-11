package com.leetcode;

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
}
