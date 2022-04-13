package easy;

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

    public static void main(String[] args) {
        final Q0104 q = new Q0104();

        final Integer[][] testcases = new Integer[][]{
                {3,9,20,null,null,15,7},
                {1, null, 2},
                {}
        };
        for (Integer[] testcase : testcases) {
            final TreeNode root = createTree(testcase);
            System.out.println(q.maxDepth(root));
        }
    }

    private static TreeNode createTree(Integer[] testcase) {
        if (testcase.length == 0) return null;
        return createTree(testcase, 0);
    }

    private static TreeNode createTree(Integer[] testcase, int index) {
        final TreeNode node = new TreeNode(testcase[index]);
        final int leftIndex = (index * 2) + 1;
        final int rightIndex = leftIndex + 1;
        if (leftIndex < testcase.length && testcase[leftIndex] != null) {
            node.left = createTree(testcase, leftIndex);
        }
        if (rightIndex < testcase.length && testcase[rightIndex] != null) {
            node.right = createTree(testcase, leftIndex + 1);
        }
        return node;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return maxDepthDFS(root, 1);
//        return maxDepthBFS(root);
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

    private int maxDepthBFS(TreeNode root) {
        final Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                final TreeNode node = queue.poll();
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
