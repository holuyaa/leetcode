package com.leetcode.medium;

import java.util.*;

public class Q0013 {
    public List<List<Integer>> threeSum(int[] numbers) {
        if (numbers.length < 3) return Collections.emptyList();
        Arrays.sort(numbers);

        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numbers.length && numbers[i] <= 0; i++) {
            for (int j = i + 1; j < numbers.length - 1; j++) {
                final int sum = numbers[i] + numbers[j];
                if (sum > 0) break;
                final int k = Arrays.binarySearch(numbers, j + 1, numbers.length, -sum);
                if (k > j) {
                    result.add(List.of(numbers[i], numbers[j], numbers[k]));
                }
                while (j < numbers.length - 1 && numbers[j] == numbers[j + 1]) j++;
            }
            while (i < numbers.length - 2 && numbers[i] == numbers[i + 1]) i++;
        }
        return result;
    }

    public List<List<Integer>> threeSum1(int[] numbers) {
        if (numbers.length < 3) return Collections.emptyList();
        Arrays.sort(numbers);

        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numbers.length - 2 && numbers[i] <= 0; i++) {
            int low = i + 1;
            int high = numbers.length - 1;
            final int target = -numbers[i];
            while (low < high) {
                final int sum = numbers[low] + numbers[high];
                if (sum < target) low++;
                else if (sum > target) high--;
                else {
                    result.add(List.of(numbers[i], numbers[low], numbers[high]));
                    while (low < high && numbers[low] == numbers[low + 1]) low++;
                    while (low < high && numbers[high] == numbers[high - 1]) high--;
                    low++;
                    high--;
                }
            }
            while (i < numbers.length - 2 && numbers[i] == numbers[i + 1]) i++;
        }
        return result;
    }
}
