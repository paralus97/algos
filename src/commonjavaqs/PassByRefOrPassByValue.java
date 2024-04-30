package commonjavaqs;

import java.util.Arrays;

public class PassByRefOrPassByValue {

    public static void main(String[] args) {
        int x = 0;
        change(x);
        System.out.println(x);

        int[] arr = {1, 2, 3};
        changeArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Java is pass by value and not pass by reference, so x is a copy and wont affect x in main
    static void change(int x) {
        x = 100;
    }

    // Same here except with arrays, a copy of the array reference is made, not just a primitive. And this copy has the same
    // value as client code. Therefore output is 100, 2, 3
    static void changeArray(int[] arr) {
        arr[0] = 1000;
    }
}
