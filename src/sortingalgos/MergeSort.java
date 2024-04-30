package sortingalgos;

// Time Complexity of BigO(nlogn)
public class MergeSort {

    // [2, 8] [5, 3], [9, 4], [7, 1]

    // Divide and conquer
    public static int[] sort(int[] array) {
        int n = array.length;
        mergeSort(array, n);
        return array;
    }

    public static void mergeSort(int[] array, int n) {
        if (n < 2) return;

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++)
            left[i] = array[i];
        for (int i = mid; i < n; i++)
            right[i - mid] = array[i];

        mergeSort(left, mid);
        mergeSort(right, n - mid);

        merge(array, left, right, mid, n - mid);
    }

    private static void merge(int[] array, int[] left, int[] right, int lIndex, int rIndex) {
        int i = 0, j = 0, k = 0;
        while (i < lIndex && j < rIndex) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }
        while (i < lIndex) {
            array[k++] = left[i++];
        }
        while (j < rIndex) {
            array[k++] = right[j++];
        }
    }
}
