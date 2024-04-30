package sortingalgos;

import java.util.Arrays;


public class Main {

    private static final int[] UNSORTED = { 2, 8, 5, 3, 9, 4 };
    private static final int[] SORTED = { 1, 2, 3, 4, 5, 7, 8, 9 };

    // Big O is a measure of the growth in time complexity of operations WRT input size n
    // O(1) < O(logn) < O(n) < O(nlogn) < O(n^2) < O(2^n) < O(n!)
    // Constant time < near constant < linear < logarithmic < quadratic < powers < factorial
    public static void main(String[] args) {
        int[] array = initialiseArray();
        verify(SORTED, InsertionSort.sort(array));

        array = initialiseArray();
        verify(SORTED, SelectionSort.sort(array));

        array = initialiseArray();
        verify(SORTED, BubbleSort.sort(array));

        array = initialiseArray();
        verify(SORTED, MergeSort.sort(array));

        array = initialiseArray();
        verify(SORTED, QuickSort.sort(array));

        // TODO: Heap Sort
    }

    private static int[] initialiseArray() {
        return new int[] { 2, 8, 5, 3, 9, 4, 7, 1 };
    }

    private static void verify(int[] expected, int[] actual) {
        if (!Arrays.equals(expected, actual)) {
            throw new RuntimeException("Array not sorted, actual: " + Arrays.toString(actual) + ", expected: " + Arrays.toString(expected));
        }
        System.err.println(Arrays.toString(expected));
    }
}