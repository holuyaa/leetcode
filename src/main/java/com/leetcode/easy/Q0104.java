package com.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

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
public class Q0104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return maxDepthDFS(root, 1);
    }

    private int maxDepthDFS(TreeNode node, int depth) {
        int left = depth;
        int right = depth;
        if (node.left != null) {
            left = maxDepthDFS(node.left, depth + 1);
        }
        if (node.right != null) {
            right = maxDepthDFS(node.right, depth + 1);
        }
        return Math.max(left, right);
    }

    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;

        final Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                final TreeNode node = queue.poll();
                if (node == null) throw new NullPointerException("node is null");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
