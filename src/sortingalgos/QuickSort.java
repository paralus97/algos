package sortingalgos;

// Worst case O(N^2)
// Average case BigO(nlogn)
public class QuickSort {
    // select pivot and put to end of array
    // itemFromLeft is first item starting from left of pivot that is Larger
    // itemFromRight is first item starting rom right of pivot that is smaller
    // swap itemFromLeft with itemFromRight
    public static int[] sort(int[] array) {
        int low = 0;
        int high = array.length - 1;
        quicksort(array, low, high);
        return array;
    }

    private static void quicksort(int[] array, int begin, int end) {
        if (begin < end) {
            int pivotIndex = partition(array, begin, end);

            quicksort(array, begin, pivotIndex - 1);
            quicksort(array, pivotIndex + 1, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                Util.swap(array, i, j);
            }
        }
        Util.swap(array, i + 1, end);
        return i + 1;
    }
}
