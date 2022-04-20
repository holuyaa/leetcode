package com.leetcode.medium;

public class Q0011 {

    /**
     * brute force
     * timeout!
     */
    public int maxArea(int[] heights) {
        int max = 0;
        for (int width = heights.length - 1; width > 0; width--) {
            for (int start = 0; start < heights.length - width; start++) {
                final int height = Math.min(heights[start], heights[start + width]);
                final int area = width * height;
                max = Math.max(max, area);
            }
        }
        return max;
    }

    public int maxArea1(int[] heights) {
        int maxArea = 0;
        int minHeight = 0;
        for (int start = 0, end = heights.length - 1; start < end; ) {
            while (heights[start] < minHeight) start++;
            while (heights[end] < minHeight) end--;

            final int leftHeight = heights[start];
            final int rightHeight = heights[end];

            final int height = Math.min(leftHeight, rightHeight);
            final int area = (end - start) * height;
            if (maxArea < area) {
                maxArea = area;
                minHeight = height;
            }

            if (leftHeight < rightHeight) start++;
            else end--;

        }
        return maxArea;
    }
}
