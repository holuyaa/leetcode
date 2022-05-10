package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Q0078 {
    public List<List<Integer>> subsets(int[] numbers) {
        final List<List<Integer>> result = new ArrayList<>();
        subsets(numbers, new ArrayList<>(), result, 0);
        return result;
    }

    private void subsets(int[] numbers, List<Integer> buffer, List<List<Integer>> result, int next) {
        result.add(new ArrayList<>(buffer));
        if (buffer.size() == numbers.length) return;
        for (int i = next; i < numbers.length; i++) {
            buffer.add(numbers[i]);
            subsets(numbers, buffer, result, i + 1);
            buffer.remove(buffer.size() - 1);
        }
    }

    public List<List<Integer>> subsets1(int[] numbers) {
        final List<List<Integer>> result = new ArrayList<>();
        subsets1(numbers, new int[numbers.length], result, 0, 0);
        return result;
    }

    private void subsets1(int[] numbers, int[] buffer, List<List<Integer>> result, int next, int pos) {
        result.add(createListFromArray(buffer, pos));
        if (pos == numbers.length) return;
        for (int i = next; i < numbers.length; i++) {
            buffer[pos] = numbers[i];
            subsets1(numbers, buffer, result, i + 1, pos + 1);
        }
    }

    private List<Integer> createListFromArray(int[] array, int n) {
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(array[i]);
        }
        return list;
    }

    public List<List<Integer>> subsets2(int[] numbers) {
        final List<List<Integer>> result = new ArrayList<>(2 ^ numbers.length);
        result.add(new ArrayList<>());
        for (int num : numbers) {
            final List<List<Integer>> tmp = new ArrayList<>(result.size());
            for (List<Integer> item : result) {
                final List<Integer> a = new ArrayList<>(item);
                a.add(num);
                tmp.add(a);
            }
            result.addAll(tmp);
        }
        return result;
    }
}
