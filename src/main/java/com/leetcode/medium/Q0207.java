package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q0207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final int[] degree = new int[numCourses];
        final boolean[][] table = new boolean[numCourses][numCourses];
        final Queue<Integer> queue = new LinkedList<>();

        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            degree[to]++;
            table[from][to] = true;
        }

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) queue.offer(i);
        }

        int count = numCourses;
        while (!queue.isEmpty()) {
            final int v = queue.poll();
            count--;
            for (int i = 0; i < numCourses; i++) {
                if (table[v][i] && --degree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return count == 0;
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        final int[] degree = new int[numCourses];
        final List<List<Integer>> outgoing = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) outgoing.add(new LinkedList<>());
        for (int[] prerequisite : prerequisites) {
            final int from = prerequisite[1];
            final int to = prerequisite[0];
            degree[to]++;
            outgoing.get(from).add(to);
        }

        final Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) queue.offer(i);
        }

        int count = prerequisites.length;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int v : outgoing.get(cur)) {
                count--;
                if (--degree[v] == 0) queue.offer(v);
            }
        }
        return count == 0;
    }
}