package com.leetcode.etc;

public class MergeSort {

    public int[] sort(int[] array) {
        final int[] tmp = new int[array.length];
        sort(array, 0, array.length, tmp);
        return tmp;
    }

    private void sort(int[] array, int left, int right, int[] tmp) {
        if (right - left < 2) return;

        final int mid = (right + left) / 2;
        sort(array, left, mid, tmp);
        sort(array, mid, right, tmp);
        merge(array, left, mid, right, tmp);
    }

    private void merge(int[] array, int left, int mid, int right, int[] tmp) {
        int l = left;
        int r = mid;
        int t = left;

        while (l < mid && r < right) {
            tmp[t++] = array[l] < array[r] ? array[l++] : array[r++];
        }

        if (l < mid) {
            System.arraycopy(array, l, tmp, t, mid - l);
        } else {
            System.arraycopy(array, r, tmp, t, right - r);
        }

        System.arraycopy(tmp, left, array, left, right - left);
    }
}
