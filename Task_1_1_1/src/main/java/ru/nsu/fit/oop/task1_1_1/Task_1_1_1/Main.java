package ru.nsu.fit.oop.task1_1_1.Task_1_1_1;

public class Main {
    /**
     * heap sorting
     * @param arr - sorting array
     */

    public static void sort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            heapify(arr, i, 0);
        }
    }

    /**
     * Procedure for converting a subtree to a binary heap with the root node i, which is an index in arr[].
     * @param arr - sorting array.
     * @param n - the heap size.
     * @param i - root node.
     */

    static  void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;

            heapify(arr, n, largest);
        }
    }
}
