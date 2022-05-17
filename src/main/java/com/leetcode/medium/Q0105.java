package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Q0105 {
    private int preorderIndex;
    private final Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        final int n = preorder.length;
        if (n == 0) return null;

        preorderIndex = 0;
        inorderMap.clear();
        for (int i = 0; i < n; i++) inorderMap.put(inorder[i], i);
        return buildTree(preorder, 0, n - 1);
    }

    private TreeNode buildTree(int[] preorder, int left, int right) {
        if (right < left) return null;

        final int rootValue = preorder[preorderIndex++];
        final TreeNode root = new TreeNode(rootValue);
        final int inIndex = inorderMap.get(rootValue);

        root.left = buildTree(preorder, left, inIndex - 1);
        root.right = buildTree(preorder, inIndex + 1, right);
        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        final int n = preorder.length;
        if (n == 0) return null;

        preorderIndex = 0;
        inorderMap.clear();
        for (int i = 0; i < n; i++) inorderMap.put(inorder[i], i);

        return buildTree1(preorder, 0, 0, n - 1);
    }

    private TreeNode buildTree1(int[] preorder, int preIndex, int left, int right) {
        if (preorder.length - 1 < preIndex || right < left) return null;

        final int rootValue = preorder[preorderIndex++];
        final TreeNode root = new TreeNode(rootValue);
        final int inIndex = inorderMap.get(rootValue);

        root.left = buildTree1(preorder, preIndex + 1, left, inIndex - 1);
        root.right = buildTree1(preorder, preIndex + inIndex - left + 1, inIndex + 1, right);
        return root;
    }
}
