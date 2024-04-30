package sortingalgos;

// BigO (N^2) - 1 where N is the size of array
public class SelectionSort {

    // During each iteration, select the smallest item from the unsorted partition and move it to the
    // sorted partition.
    // Keep track of current min and current item
    static int[] sort(int[] array) {

//        for (int i = 0; i < array.length - 1; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[j] < array[minIndex]) {
//                    minIndex = j;
//                }
//            }
//            if (minIndex != i) {
//                Util.swap(array, i, minIndex);
//            }
//        }

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j ++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Util.swap(array, i, minIndex);
            }
        }
        return array;
    }
}
