package com.leetcode.medium;

public class Q0200 {
    public int numIslands(char[][] grid) {
        final int n = grid.length;
        final int m = grid[0].length;

        int count = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (grid[y][x] == '0') continue;
                count++;
                visit(grid, x, y);
            }
        }
        return count;
    }

    private void visit(char[][] grid, int x, int y) {
        if (x < 0 || grid[0].length <= x || y < 0 || grid.length <= y) return;
        if (grid[y][x] == '0') return;

        grid[y][x] = '0';

        visit(grid, x - 1, y);
        visit(grid, x, y - 1);
        visit(grid, x + 1, y);
        visit(grid, x, y + 1);
    }
}
