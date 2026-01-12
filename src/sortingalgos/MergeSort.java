package sortingalgos;

// Time Complexity of BigO(nlogn)
public class MergeSort {

    // [2, 8] [5, 3], [9, 4], [7, 1]

    // Divide et Impera
    public static int[] sort(int[] array) {
        int n = array.length;
        mergeSort(array, n);
        return array;
    }

    // Half the array until there is no more than 2 items using recursion
    // Then, call merge on each returned array
    public static void mergeSort(int[] array, int n) {
//        if (n < 2) return;
//
//        int mid = n / 2;
//        int[] left = new int[mid];
//        int[] right = new int[n - mid];
//
//        for (int i = 0; i < mid; i++)
//            left[i] = array[i];
//        for (int i = mid; i < n; i++)
//            right[i - mid] = array[i];
//
//        mergeSort(left, mid);
//        mergeSort(right, n - mid);
//
//        merge(array, left, right, mid, n - mid);
        if (n < 2) return;
        int mid = (array.length / 2);
        int[] arrayLeft = new int[mid];
        // maybe this is a size 1 array
        int[] arrayRight = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            arrayLeft[i]  = array[i];
        }
        for (int i = mid; i < n; i++) {
            arrayRight[i - mid] = array[i];
        }
        // Recursively split left till its size 2
        mergeSort(arrayLeft, mid);
        // Recursively split right till its size 2
        mergeSort(arrayRight, n - mid);

        // Sort each partition, modify original array
        merge(array, arrayLeft, arrayRight, mid, n - mid);
    }

    private static void merge(int[] array, int[] left, int[] right, int lMaxIndex, int rMaxIndex) {
        // i for left array, j for right array, k for result array
        int i = 0, j = 0, k = 0;
        //Sort the partitions out
        while (i < lMaxIndex && j < rMaxIndex) {
            //if partitions are in order...
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            // Else, move right to sorted partition
            } else {
                array[k++] = right[j++];
            }
        }
        // Then place the rest
        while (i < lMaxIndex) {
            array[k++] = left[i++];
        }
        while (j < rMaxIndex) {
            array[k++] = right[j++];
        }
    }
}
