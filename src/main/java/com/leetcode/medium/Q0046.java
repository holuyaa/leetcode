package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q0046 {
    public List<List<Integer>> permute(int[] numbers) {
        final List<List<Integer>> result = new ArrayList<>();
        permute(numbers, new boolean[numbers.length], new ArrayList<>(), result);
        return result;
    }

    private void permute(int[] numbers, boolean[] visited, List<Integer> tmp, List<List<Integer>> result) {
        if (tmp.size() == numbers.length) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(numbers[i]);
                permute(numbers, visited, tmp, result);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
