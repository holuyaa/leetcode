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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        final int n = preorder.length;
        if (n == 0) return null;

        preorderIndex = 0;
        final Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n - 1, inorderMap);
    }

    private TreeNode buildTree(int[] preorder, int left, int right, Map<Integer, Integer> inorderMap) {
        if (right < left) return null;

        final int rootValue = preorder[preorderIndex++];
        final TreeNode root = new TreeNode(rootValue);

        root.left = buildTree(preorder, left, inorderMap.get(rootValue) - 1, inorderMap);
        root.right = buildTree(preorder, inorderMap.get(rootValue) + 1, right, inorderMap);
        return root;
    }
}
