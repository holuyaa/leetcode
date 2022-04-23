package com.leetcode.medium;

public class Q0031 {

    public void nextPermutation(int[] numbers) {
        final int start = getStart(numbers);
        if (start >= 0) swap(numbers, start, getEnd(numbers, start));
        reverse(numbers, start + 1);
    }

    private int getStart(int[] numbers) {
        int i = numbers.length - 2;
        while (i >= 0 && numbers[i + 1] <= numbers[i]) i--;
        return i;
    }

    private int getEnd(int[] numbers, int i) {
        int j = numbers.length - 1;
        while (numbers[j] <= numbers[i]) j--;
        return j;
    }

    private void swap(int[] numbers, int a, int b) {
        final int tmp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = tmp;
    }

    private void reverse(int[] numbers, int start) {
        int i = start;
        int j = numbers.length - 1;
        while (i < j) swap(numbers, i++, j--);
    }
}
