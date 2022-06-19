package com.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Q0207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        final int[] degree = new int[numCourses];
        final boolean[][] table = new boolean[numCourses][numCourses];
        final boolean[] visited = new boolean[numCourses];
        final Queue<Integer> queue = new LinkedList<>();

        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            degree[to]++;
            table[from][to] = true;
        }

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] != 0) continue;
            visited[i] = true;
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            final int v = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (table[v][i] && !visited[i] && --degree[i] == 0) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}