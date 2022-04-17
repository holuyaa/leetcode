package com.leetcode.etc;

public class MergeSort {

    public int[] sort(int[] array) {
        final int[] tmpArray = new int[array.length];
        sort(array, 0, array.length - 1, tmpArray);
        return array;
    }

    private void sort(int[] array, int left, int right, int[] tmpArray) {
        if (left == right) return;

        final int mid = (right + left) / 2;
        sort(array, left, mid, tmpArray);
        sort(array, mid + 1, right, tmpArray);
        merge(array, left, right, tmpArray);
    }

    private void merge(int[] array, int left, int right, int[] tmpArray) {
        final int mid = (right + left) / 2;

        int l = left;
        int r = mid + 1;
        int s = left;
        while (l <= mid && r <= right) {
            tmpArray[s++] = array[l] <= array[r] ? array[l++] : array [r++];
        }

        if (l > mid) {
            for (int i = r; i <= right; i++) {
                tmpArray[s++] = array[i];
            }
        } else {
            for (int i = l; i <= mid; i++) {
                tmpArray[s++] = array[i];
            }
        }

        System.arraycopy(tmpArray, left, array, left, right + 1 - left);
    }
}
