package challengequestions;

// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]

// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]

// Constraints:
// 2 <= nums.length <= 104
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// Only one valid answer exists.

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoNumsResult {

    public static int[] getIndexes(int target, int[] input) {
        // place all of input into a hashmap
        // iterate through our list
        // as we iterate through list we can a quick op which looks like
        //      map.contains((target - input[index]))
        //      if it does contain, then get the value will be the index

        // 6
        // 3, 2, 4
        // int[] res = new int[2];
        // int currentNum;
        // for (int i = 0; i < input.length; i ++) {
        //     currentNum = input[i];

        //     // key could be integer
        //     // value could be the index


        //     for (int j = 0; j < input.length && j != i; j++) {
        //         if (currentNum + input[j] == target) {
        //             return new int[] {i, j};
        //         }
        //     }
        // }

        // target 6
        // 3, 3
        // K is value of num, V is index

        // Each HashMap has a Key of Integer to lookup and a Queue of indices that they are located at

//        Map<Integer, Integer> intMap = new HashMap<>();
//        for (int i = 0; i < input.length; i++) {
//            intMap.put(input[i], i);
//        }
//
//        System.out.println(intMap);
//
//        for (int i = 0; i < input.length; i++) {
//            int diff = target - input[i];
//            if (intMap.containsKey(diff) && i != intMap.get(diff)) {
//                return new int[] { i, intMap.get(diff) };
//            }
//        }
//        return null;

        Map<Integer, List<Integer>> intMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (intMap.containsKey(input[i])) {
                List<Integer> indices = intMap.get(input[i]);
                indices.add(i);
                intMap.put(input[i], indices);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                intMap.put(input[i], indices);
            }
        }


        for (int i = 0; i < input.length; i++) {
            int diff = target - input[i];
            if (intMap.containsKey(diff)) {
                List<Integer> indices = intMap.get(diff);
                for (int index : indices) {
                    if (index != i) {
                        return new int[] { i, index};
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // ....
        // 2, 7, 11, 15
        // 2, 7  ... 9
        int [] testOne = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(getIndexes(target, testOne)));

        int [] testTwo = {3, 2, 4};
        target = 6;
        System.out.println(Arrays.toString(getIndexes(target, testTwo)));
        // 2, 3, 4   = 6

        int [] testThree = {3, 3};
        target = 6;
        System.out.println(Arrays.toString(getIndexes(target, testThree)));
    }

}