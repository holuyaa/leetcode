package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
public class Q0102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        levelOrder(root, 0, result);
        return result;
    }

    private void levelOrder(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;
        if (result.size() == level) result.add(new ArrayList<>());
        result.get(level).add(node.val);
        levelOrder(node.left, level + 1, result);
        levelOrder(node.right, level + 1, result);
    }

    public List<List<Integer>> levelOrder1(TreeNode node) {
        final List<List<Integer>> result = new ArrayList<>();
        final Queue<TreeNode> queue = new LinkedList<>();
        if (node != null) queue.offer(node);
        while (!queue.isEmpty()) {
            final int size = queue.size();
            final List<Integer> subList = new ArrayList<>();
            result.add(subList);
            for (int i = 0; i < size; i++) {
                final TreeNode curr = queue.poll();
                assert curr != null;
                subList.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return result;
    }
}
