package sortingalgos;

import java.util.Arrays;

// O(N^2) - 1 where N is the size of array
public class InsertionSort {

    // Work from left to right
    // Examine each item and compare to items on left
    // Insert the item in to the correct position in array
    static int[] sort(int[] array) {
//        for (int i = 1 ; i < array.length; i++) {
//            int j = i;
//            while (j > 0 && array[j - 1] > array[j]) {
//                int tmp = array[j - 1];
//                array[j - 1] = array[j];
//                array[j] = tmp;
//                j--;
//            }
//        }
//        for (int i = 0; i < array.length; i++)
//            for (int j = i; j > 0; j--)
//                if (array[j - 1] > array[j])
//                    Util.swap(array, j, j - 1);
//        return array;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    Util.swap(array, j, j -1);
                }
            }
        }
        return array;
    }
}
