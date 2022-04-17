package com.leetcode.etc;

public class MergeSort {

    public int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    private void sort(int[] array, int left, int right) {
        if (right == left) return;

        final int mid = (right + left) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, right);
    }

    private void merge(int[] array, int left, int right) {
        final int[] tmp = new int[right - left + 1];
        final int mid = (right + left) / 2;

        int l = left;
        int r = mid + 1;
        int t = 0;

        while (l <= mid && r <= right) {
            tmp[t++] = array[l] <= array[r] ? array[l++] : array [r++];
        }

        if (l <= mid) {
            System.arraycopy(array, l, tmp, t, mid - l + 1);
        } else {
            System.arraycopy(array, r, tmp, t, right - r + 1);
        }

        System.arraycopy(tmp, 0, array, left, right - left + 1);
    }
}
