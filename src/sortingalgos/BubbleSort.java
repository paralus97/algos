package sortingalgos;

// BigO(N^2 - 1)
public class BubbleSort {

    // The natural/intuitive sort
    public static int[] sort(int[] array) {
//        for (int i = 0; i < array.length; i ++) {
//            for (int j = 0; j < array.length - 1; j++) {
//                if (array[i] < array[j]) {
//                    Util.swap(array, i, j);
//                }
//            }
//        }
//        return array;


//        // highest number will "bubble" its way to the right with each iteration
//        // hence the array.length - i - 1 condition
//        for (int i = 0; i < array.length; i ++) {
//            for (int j = 0; j < array.length - i - 1; j++) {
//                if (array[j + 1] < array[j])
//                    Util.swap(array, j, j + 1);
//            }
//        }
//        return array;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    Util.swap(array, j + 1, j);
                }
            }
        }
        return array;
    }
}
