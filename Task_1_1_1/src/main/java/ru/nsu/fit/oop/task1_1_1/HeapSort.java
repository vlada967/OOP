package ru.nsu.fit.oop.task1_1_1;

public class HeapSort {
    /**
    * heap sorting
    * @param arr - sorting array
    */
    public static void sort(int arr[]) {
        if (arr == null) {
            throw new IllegalArgumentException("Null array is not allowed");
        }
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
    /**
     * Procedure for converting a subtree to a binary heap with the root node i.
     * @param arr - sorting array.
     * @param n - the heap size.
     * @param i - root node.
     */
    private static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private static void swap (int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

}
