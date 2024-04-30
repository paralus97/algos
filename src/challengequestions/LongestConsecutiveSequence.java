package challengequestions;


import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /*
     * Complete the 'longestConsecutive' function below.
     *
     * The function is expected to return an integer.
     * The function accepts integer array nums as parameter.
     */

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums)
            set.add(num);

        int longestStreak = 0;
        // Iterate over each element in array
        for (Integer n : set) {
            int currentStreak = 0;
            // If set does not contain (n - 1) then it could be start of sequence
            if (!set.contains(n - 1)) {
                currentStreak++;
                int nextVal = n;
                // each lookup is a constant op O(1)
                while (set.contains(nextVal + 1)) {
                    currentStreak++;
                    nextVal++;
                }
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        // streak of 1, 2, 3, 4 so answer is 4
        int[] test = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(test));
    }
}
